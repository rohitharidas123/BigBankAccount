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
		nextAccNum++;
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
		nextAccNum++;
		name = n;
		balance = b;
	}
	
	//methods
	/**
	 * adds money to balance
	 * @param amt: amount of money
	 */
	public void deposit(double amt)
	{
		balance += amt;
	}
	
	/**
	 * takes out money
	 * @param amt: amount of money
	 */
	public void withdraw(double amt)
	{
		balance -= amt;
	}
	
	/**
	 * 
	 * @return: returns name of account
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * 
	 * @return: returns balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * will be implemented in checkingaccount and savingsaccount classes
	 */
	public abstract void endofMonthUpdate();
	
	/**
	 * 
	 * @param other: represents bank account that will be receiving the transferred money
	 * @param amt : amount that will be transfered
	 */
	public void transfer(BankAccount other, double amt)
	{
		balance -= amt;
		other.deposit(amt);
	}
	
	/**
	 * prints a bank accounts number, name, and balance
	 */
	public String toString()
	{
		return ("Account Number: " + acctNum +  "\t" + "Accountholder name: " + name + "\t" + "Balance: " + balance);
	}
	
	/**
	 * 
	 * @return: returns bank account number
	 */
	public int getAcctNum()
	{
		return acctNum;
	}
}