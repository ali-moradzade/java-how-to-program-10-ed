package FileMatching;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTransaction
{
	private static Formatter outTransaction;
	
	public static void openTransaction()
	{
		try
		{
			outTransaction = new Formatter("trans.txt");
		}
		catch (SecurityException securityException)
		{
			System.err.println(
				"Write permission denied for trans.txt file. Terminating.");
			System.exit(1);
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening tranx.txt file. Terminating.");
			System.exit(1);
		}
	}
	
	public static void addTransactionRecords()
	{
		Scanner input = new Scanner(System.in);
		System.out.printf("%s%n%s%n? ",
			"Enter account number and amount.",
			"Enter end-of-file indicator to end input.");
		
		while (input.hasNext())
		{
			try
			{
				outTransaction.format("%d %.2f%n",
					input.nextInt(), input.nextDouble());
			}
			catch (FormatterClosedException formatterClosedException)
			{
				System.err.println(
					"Error writing to trans.txt file. Terminating.");
				break;
			}
			catch (NoSuchElementException elementException)
			{
				System.err.println("Invalid input. Please try again.");
				input.nextLine();
			}
			
			System.out.print("? ");
		}
	}
	
	public static void closeTransactionFile()
	{
		if (outTransaction != null)
			outTransaction.close();
	}
	
	public static void main(String[] args)
	{
		openTransaction();
		addTransactionRecords();
		closeTransactionFile();
	}
}
