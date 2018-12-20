/**
 * 
 * @author Rohit Haridas
 * Pd 6
 *AP Comp Sci
 */
public abstract class BankAccount 
{
	//fields
	private static int nextAccNum;
	private String name;
	private int acctNum;
	private double balance;

	//constructors
	/**
	 * 
	 * @param n: name of the account holder
	 */
	public BankAccount(String n)
	{
		acctNum = nextAccNum;
		name = n;
	}
	
	/**
	 * 
	 * @param n: name of the account
	 * @param b: balance in the account
	 */
	public BankAccount(String n, double b)
	{
		acctNum = nextAccNum;
		name = n;
		balance = b;
	}
	
	//methods
	public void deposit(double amt)
	{
		balance += amt;
	}
	
	public void withdraw(double amt)
	{
		balance -= amt;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public abstract void endofMonthUpdate();
	
	public void transfer(BankAccount other, double amt)
	{
		balance -= amt;
		other.deposit(amt);
	}
	
	public String toString()
	{
		return (acctNum +  "\t" + name + "\t" + balance);
	}
	
	public int getAcctNum()
	{
		return acctNum;
	}
}