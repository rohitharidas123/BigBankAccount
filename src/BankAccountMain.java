import java.util.ArrayList;
import java.util.Scanner;
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
			double FREE_TRANSACTIONS = 10;
			boolean program = true;
			while (program == true)
			{
				System.out.println("Would you like to add an account? (Y/N)");
					if(in.nextLine() == "y" || in.nextLine() == "Y")
			
				System.out.println("Would you like to make a transaction? (Y/N");
			
				System.out.println("Would you like to terminate the program? (Y/N");
				{
					if(in.nextLine() == "y" || in.nextLine() == "Y")
						program = false;
					if(in.nextLine() == "n" || in.nextLine() == "N")
						program = true;
					else
					{
						System.out.println("Try again you idiot");
						in.nextLine();
					}
				}	
			}
	}
}

