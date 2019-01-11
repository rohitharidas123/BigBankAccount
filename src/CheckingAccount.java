public class CheckingAccount extends BankAccount
{
	//fields
	private final double OVER_DRAFT_FEE;
	private final double TRANSACTION_FEE;
	private final double FREE_TRANS;
	private int numTransactions;
	
	//constructors
	/**
	 * 
	 * @param n: name of the account holder
	 * @param b: balance of account
	 * @param odf: constant overdraft fee
	 * @param tf: constant transaction fee
	 * @param freeTrans: allows free transaction
	 */
	public CheckingAccount(String n, double b, double odf, double tf, int freeTrans)
	{
		super(n, b);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	/**
	 * 
	 * @param n: name of the account holder
	 * @param odf: constant overdraft fee
	 * @param tf: constant transaction fee
	 * @param freeTrans: allows free transaction
	 */
	public CheckingAccount(String n, double odf, double tf, int freeTrans)
	{
		this(n, 0, odf, tf, freeTrans);
	}
	
	//methods
	/**
	 * extension of deposit method
	 * withdraws transaction fee if user exceeds number of free transactions
	 * amount still must be at least 0
	 */
	public void deposit(double amt)
	{
		if(amt>=0)
		{
			super.deposit(amt);
			numTransactions++;
			if (numTransactions>FREE_TRANS)
				super.withdraw(TRANSACTION_FEE);
		}
		else
			throw new IllegalArgumentException();
	}
	
	/**
	 * extension of withdraw method
	 * withdraws transaction fee if user exceeds number of free transactions
	 * amount withdrawn must be at least 0
	 * only allowed to withdraw if initial balance is positive
	 * if withdrawing more than balance, over draft fee will be charged
	 */
	public void withdraw(double amt)
	{
		if(super.getBalance()<0 || amt<0)
			throw new IllegalArgumentException();
		else
		{
			super.withdraw(amt);
			numTransactions++;
			if(numTransactions>FREE_TRANS)
				super.withdraw(TRANSACTION_FEE);
			if(super.getBalance()<0)
				super.withdraw(OVER_DRAFT_FEE);
		}
	}
	
	/**
	 * transfers money from one account to the other as long as they are under the same name
	 * cannot transfer more than initial balance
	 */
	public void transfer(BankAccount other, double amt)
	{
		if(other.getName().equals(super.getName()))
		{
			if(amt>super.getBalance())
				throw new IllegalArgumentException();
			else
			{
				this.withdraw(amt);
				other.deposit(amt);
			}
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * resets number of transactions to 0 at end of month
	 */
	public void endofMonthUpdate()
	{
		numTransactions = 0;
	}

}