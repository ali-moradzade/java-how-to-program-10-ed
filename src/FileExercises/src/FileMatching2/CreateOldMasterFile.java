package FileMatching2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateOldMasterFile
{
	private static ObjectOutputStream output;
	
	public static void openFile()
	{
		try
		{
			output = new ObjectOutputStream(
				Files.newOutputStream(Paths.get("oldmast.ser")));
		}
		catch (IOException iOException)
		{
			System.err.println("Error opening \"oldmast.ser\". Terminating.");
			iOException.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	public static void addRecords()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.printf("%s%n%s%n? ",
			"Enter account number, first name, last name and balance.",
			"Enter end-of-file indocator to end input.");
		
		while (input.hasNext())
		{
			try
			{
				Account account = new Account(input.nextInt(), input.next(),
					input.next(), input.nextDouble());
				
				output.writeObject(account);
			}
			catch (NoSuchElementException elementException)
			{
				System.out.println("Invalid input. Please try again.");
				input.nextLine();
			}
			catch (IOException iOException)
			{
				System.err.println("Error writing to \"oldmast.ser\". Terminating.");
				iOException.printStackTrace(System.out);
				System.exit(1);
			}
			
			System.out.print("? ");
		}
	}
	
	public static void closeFile()
	{
		try
		{
			if (output != null)
				output.close();
		}
		catch (IOException iOException)
		{
			System.err.println("Error closing \"oldmast.ser\". Terminating.");
			iOException.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	public static void main(String[] args)
	{
		openFile();
		addRecords();
		closeFile();
	}
}
