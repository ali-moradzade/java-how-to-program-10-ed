package FileMatching;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateOldMaster
{
	private static Formatter outOldMaster;
	
	public static void openOldMaster()
	{
		try
		{
			outOldMaster = new Formatter("oldmast.txt");
		}
		catch (SecurityException securityException)
		{
			System.err.println(
				"Write permission denied for oldmast.txt file. Terminating.");
			System.exit(1);
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening oldmast.txt file. Terminating.");
			System.exit(1);
		}
	}
	
	public static void addOldMasterRecords()
	{
		Scanner input = new Scanner(System.in);
		System.out.printf("%s%n%s%n? ",
			"Enter account number, first name, last name and balance.",
			"Enter end-of-file indicator to end input.");
		
		while (input.hasNext())
		{
			try
			{
				outOldMaster.format("%d %s %s %.2f%n",
					input.nextInt(), input.next(), input.next(), input.nextDouble());
			}
			catch (FormatterClosedException formatterClosedException)
			{
				System.err.println(
					"Error writing to oldmast.txt file. Terminating.");
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
	
	public static void closeOldMasterFile()
	{
		if (outOldMaster != null)
			outOldMaster.close();
	}
	
	public static void main(String[] args)
	{
		openOldMaster();
		addOldMasterRecords();
		closeOldMasterFile();
	}
}
