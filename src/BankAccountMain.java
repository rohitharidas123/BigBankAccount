import java.util.Scanner;
import java.util.ArrayList;
public class BankAccountMain 
{

	public static void main(String[] args) 
	{
			Scanner in = new Scanner(System.in);
			ArrayList<BankAccount> Accounts = new ArrayList<BankAccount>();
			double OVER_DRAFT_FEE = 15;
			double RATE = .0025;
			double TRANSACTION_FEE = 1.5;
			double MIN_BAL = 300;
			double MIN_BAL_FEE = 10;
			int FREE_TRANSACTIONS = 10;
			boolean program = true;
			while (program == true)
			{
				System.out.println("Would you like to add an account? (Y/N)");
					String accountResponse = in.nextLine();
					if ((accountResponse.equals("y")) || (accountResponse.equals("Y")))
					{
						System.out.println("Would you like to create a savings account or a checkings account? (S/C)");
							String acctTypeResponse = in.nextLine();
						if(acctTypeResponse.equals("S") || acctTypeResponse.equals("s"))
						{
							System.out.println("Please enter the name for your account");
							String sName = in.nextLine();
							System.out.println("Enter a number for the account number");
							int num = in.nextInt();
							Accounts.add(new SavingsAccount(sName, 0, RATE, MIN_BAL, MIN_BAL_FEE));
						}
						
						else if(acctTypeResponse.equals("C") || acctTypeResponse.equals("c"))
						{
							System.out.println("Please enter the name for your account");
							String cName = in.nextLine();
							System.out.println("Enter a number for the account number");
							int num = in.nextInt();
							Accounts.add(new CheckingAccount(cName, 0, OVER_DRAFT_FEE, MIN_BAL_FEE, FREE_TRANSACTIONS));
						}
						
						else
						{
							System.out.println("You typed something wrong, please enter S or C.");
							acctTypeResponse = in.nextLine();
						}	
					}	
					
					else if ((accountResponse.equals("n")) || (accountResponse.equals("N")))
					{
						System.out.println("Would you like to make a transaction? (Y/N)");
							String transResponse = in.nextLine();
						if ((transResponse.equals("y")) || (transResponse.equals("Y")))
						{
							System.out.println("Would you like to withdraw, deposit, transfer, or get an account number? (W/D/T/N)");
							String option = in.nextLine();
							if((option.equals("W")) || (option.equals("w")))
							{
								System.out.println("What account number would you like to withdraw money from?");
								int acctNum = in.nextInt();
								System.out.println("How much money would you like to withdraw?");
								double amt = in.nextDouble();
								Accounts.get(acctNum).withdraw(amt);
							}
							else if((option.equals("D")) || (option.equals("d")))
							{
								System.out.println("What account number would you like to deposit money from?");
								int acctNum = in.nextInt();
								System.out.println("How much money would you like to deposit?");
								double amt = in.nextDouble();
								Accounts.get(acctNum).deposit(amt);
							}
							else if((option.equals("T")) || (option.equals("t")))
							{
								System.out.println("What account number would you like to transfer money from?");
								int acctNum1 = in.nextInt();
								System.out.println("What account number would you like to transfer money to?");
								int acctNum2 = in.nextInt();
								System.out.println("How much money would you like to transfer?");
								double amt = in.nextDouble();
								System.out.println(Accounts);
								Accounts.get(acctNum1).transfer(Accounts.get(acctNum2), amt);
							}
							else if((option.equals("N")) || (option.equals("n")))
							{
								System.out.println("Under what name is the account number you are looking for?");
								String name = in.nextLine();
								if(name.equals(Accounts.getName()))
								
							}
							else
							{
								System.out.println("You typed something invalid. Please enter W, D, T, or N to conduct a transaction.");
								option = in.nextLine();
							}
						}
						
						else if ((transResponse.equals("n")) || (transResponse.equals("N")))
						{
							System.out.println("Would you like to terminate the program? (Y/N)");
							{
								String programResponse = in.nextLine();
								if ((programResponse.equals("y")) || (programResponse.equals("Y")))
									program = false;
								else if ((programResponse.equals("n")) || (programResponse.equals("N")))
									program = true;
								else
								{
									System.out.println("Try again. Type Y or N.");
									programResponse = in.nextLine();
								}
							}
						}
						else
						{
							System.out.println("You typed something invalid. Please enter Y or N.");
							String programResponse = in.nextLine();
						}
			}	
		}
	}
}