package CreateTextFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class CreditInquiry
{
	private static final MenuOption[] choices = MenuOption.values();
	
	public static void main(String[] args)
	{
		MenuOption accountType = getRequest();
		
		while (accountType != MenuOption.ENT)
		{
			switch (accountType)
			{
				case ZERO_BALANCE:
					System.out.println("Accounts with zero balances:");
					break;
				case CREDIT_BALANCE:
					System.out.println("Accounts with credit balances:");
					break;
				case DEBIT_BALANCE:
					System.out.println("Accounts with debit balances:");
					break;
			}
			
			readRecords(accountType);
			accountType = getRequest();
		}
	}
	
	private static MenuOption getRequest()
	{
		int request = 4;
		
		System.out.printf("%nEnter request:%n%s%n%s%n%s%n%s%n",
			"1 - List accounts with zero balances",
			"2 - List accounts with credit balances",
			"3 - List accounts with debit balances",
			"4 - Terminate program");
		
		try
		{
			Scanner input = new Scanner(System.in);
			
			do
			{				
				System.out.printf("? ");
				request = input.nextInt();
			} while ((request < 1) || (request > 4));
		}
		catch (NoSuchElementException elementException)
		{
			System.err.println("Invalid input. Terminating.");
		}
		
		return choices[request - 1];
	}
	
	private static void readRecords(MenuOption accountType)
	{
		try (Scanner input = new Scanner(Paths.get("clients.txt")))
		{
			System.out.printf("%-10s%-12s%-12s%10s%n",
						"Account", "First Name", "Last Name", "Balance");
			
			while (input.hasNext())
			{
				int accountNumber = input.nextInt();
				String firstName = input.next();
				String lastName = input.next();
				double balance = input.nextDouble();
				
				if (shouldDisplay(accountType, balance))
					System.out.printf("%-10d%-12s%-12s%10.2f%n",
						accountNumber, firstName, lastName, balance);
				else
					input.nextLine();
			}
		}
		catch (NoSuchElementException | IllegalStateException | IOException e)
		{
			System.err.println("Error processing file. Terminating.");
			System.exit(1);
		}
	}
	
	private static boolean shouldDisplay(MenuOption accountType, double balance)
	{
		if ((accountType == MenuOption.ZERO_BALANCE) && (balance == 0.0))
			return true;
		else if ((accountType == MenuOption.DEBIT_BALANCE) && (balance > 0.0))
			return true;
		else if ((accountType == MenuOption.CREDIT_BALANCE) && (balance < 0.0))
			return true;
		
		return false;
	}
}
