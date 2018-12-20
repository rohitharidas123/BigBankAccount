
public class SavingsAccount extends BankAccount
{
	//fields
	private double intRate;
	private final double MIN_BAL;
	private final double MIN_BAL_FEE;
	
	//constructors
	public SavingsAccount(String n, double b, double r, double mb, double mbf)
	{
		super(n, b);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}

	public SavingsAccount(String n, double r, double mb, double mbf)
	{
		this(n, 0, r, mb, mbf);
	}
	
	//methods
	public void deposit(double amt)
	{
		if(amt>0)
			super.deposit(amt);
		else
			throw new IllegalArgumentException();
	}
	
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
	
	public void addInterest()
	{
		super.deposit(super.getBalance()*intRate);
	}

	public void endofMonthUpdate()
	{
		this.addInterest();
	}
}
