
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
	
	public CheckingAccount(String n, double odf, double tf, int freeTrans)
	{
		this(n, 0, odf, tf, freeTrans);
	}
	
	//methods
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
	
	public void transfer(BankAccount other, double amt)
	{
		if(other.getName() == super.getName())
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
	
	public void endofMonthUpdate()
	{
		numTransactions = 0;
	}

}

