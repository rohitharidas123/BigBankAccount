import java.util.Scanner;
import java.util.ArrayList;
public class BankAccountMain 
{
	private static boolean isNumeric(String str)
	{
		try
		{
			Double.parseDouble(str);
			return true;
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
	}
	
	private static boolean isAcctNum(String str)
	{
		try
		{
			Integer.parseInt(str);
			return true;
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
	}


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
							Accounts.add(new SavingsAccount(sName, 0, RATE, MIN_BAL, MIN_BAL_FEE));
						}
						
						else if(acctTypeResponse.equals("C") || acctTypeResponse.equals("c"))
						{
							System.out.println("Please enter the name for your account");
							String cName = in.nextLine();
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
							try
							{
							if((option.equals("W")) || (option.equals("w")))
							{
								System.out.println("What account number would you like to withdraw money from?");
								String acctNum = in.next();
								in.nextLine();
								while(!isAcctNum(acctNum))
								{
									System.out.println("Account does not exist.  Please enter again: ");
									acctNum = in.next();
									in.nextLine();
								}
								if(isAcctNum(acctNum))
								{
								for(BankAccount account : Accounts)
								{
									if(account.getAcctNum() == Integer.parseInt(acctNum))
									{
										System.out.println("How much money would you like to withdraw?");
										double amt = in.nextDouble();
										try
										{
											account.withdraw(amt);
										}
										catch(IllegalArgumentException e)
										{
											System.out.println("Transaction not authorized");
										}
									}
									else
									{
										System.out.println("There are no accounts under that number. Please enter another number: ");
										acctNum = in.next();
									}
								}
								}
							}
							else if((option.equals("D")) || (option.equals("d")))
							{
								System.out.println("What account number would you like to deposit money into?");
								String acctNum = in.next();
								in.nextLine();
								while(!isAcctNum(acctNum))
								{
									System.out.println("Account does not exist.  Please enter again: ");
									acctNum = in.next();
									in.nextLine();
								}
								if(isAcctNum(acctNum))
								{
								for(BankAccount account : Accounts)
								{
									if(account.getAcctNum() == Integer.parseInt(acctNum))
									{
										System.out.println("How much money would you like to deposit?");
										double amt = in.nextDouble();
										try
										{
											account.deposit(amt);
										}
										catch(IllegalArgumentException e)
										{
											System.out.println("Transaction not authorized");
										}
									}
									else
									{
										System.out.println("There are no accounts under that number. Please enter another number: ");
										acctNum = in.next();
									}
								}
								}
							}
							else if((option.equals("T")) || (option.equals("t")))
							{
								System.out.println("What account number would you like to transfer money from?");
								String acctNum1 = in.next();
								System.out.println("What account number would you like to transfer money to?");
								String acctNum2 = in.next();
								while(!isAcctNum(acctNum1))
								{
									System.out.println("The first account number you entered does not exist.  Please enter again: ");
									acctNum1 = in.next();
									in.nextLine();
								}
								while(!isAcctNum(acctNum2))
								{
									System.out.println("The second account number you entered does not exist.  Please enter again: ");
									acctNum2 = in.next();
									in.nextLine();
								}
								for(BankAccount account : Accounts)
								{
									if(account.getAcctNum() == Integer.parseInt(acctNum1) && account.getAcctNum() == Integer.parseInt(acctNum2))
									{
								System.out.println("How much money would you like to transfer?");
								double amt = in.nextDouble();
								try
								{
									account.transfer(acctNum2, amt);
								}
								catch(IllegalArgumentException e)
								{
									System.out.println("Transaction not authorized");
								}
							}
							else if((option.equals("N")) || (option.equals("n")))
							{
								System.out.println("Under what name is the account number you are looking for?");
								String name = in.nextLine();
								for(BankAccount account : Accounts)
									{
										if(name.equals(account.getName()))
											System.out.println("The account number is " + account.getAcctNum());
										
										else
										{
											System.out.println("There are no accounts under that name. Please enter another name: ");
											name = in.nextLine();
										}
									}
							}
							else
							{
								System.out.println("You typed something invalid. Please enter W, D, T, or N to conduct a transaction.");
								option = in.nextLine();
							}
						}
						catch(IllegalArgumentException e)
							{
								System.out.println("Transaction not authorized.");
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