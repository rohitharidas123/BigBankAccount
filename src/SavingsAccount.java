
public class SavingsAccount extends BankAccount
{
	//fields
	private double intRate;
	private final double MIN_BAL;
	private final double MIN_BAL_FEE;
	
	//constructors
	/**
	 * 
	 * @param n: name of the account holder
	 * @param b: balance of account
	 * @param r: interest rate
	 * @param mb: minimum balance allowed in account
	 * @param mbf: fee for going below minimum balance
	 */
	public SavingsAccount(String n, double b, double r, double mb, double mbf)
	{
		super(n, b);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	/**
	 * 
	 * @param n: name of the account holder
	 * @param r: interest rate
	 * @param mb: minimum balance allowed in account
	 * @param mbf: fee for going below minimum balance
	 */
	public SavingsAccount(String n, double r, double mb, double mbf)
	{
		this(n, 0, r, mb, mbf);
	}
	
	//methods
	/**
	 * deposits money as long as amount is positive
	 */
	public void deposit(double amt)
	{
		if(amt>=0)
			super.deposit(amt);
		else
			throw new IllegalArgumentException();
	}
	
	/**
	 * withdraws money as long as amount is positive and withdrawing the money will not result in a negative balance
	 * if withdrawing money results in balance being less than the minimum balance, fee will be charged
	 */
	public void withdraw(double amt)
	{
		if(amt>=0)
		{
			if(super.getBalance() - amt < 0)
			{
				throw new IllegalArgumentException();
			}
			else
			{
				super.withdraw(amt);
				if(super.getBalance()< MIN_BAL)
					super.withdraw(MIN_BAL_FEE);
			}
		}
		else
			throw new IllegalArgumentException();
	}
	
	/**
	 * transfers money between two accounts as long as they are under same name
	 * amount cannot exceed balance of initial account
	 */
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
	
	/**
	 * adds interest to an account
	 */
	public void addInterest()
	{
		super.deposit(super.getBalance()*intRate);
	}
	
	/**
	 * adds interest at end of month
	 */
	public void endofMonthUpdate()
	{
		this.addInterest();
	}
}