package SerializationApps;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class CreateSequentialFile
{
	private static ObjectOutputStream output;
	
	public static void openFile()
	{
		try
		{
			output = new ObjectOutputStream(
				Files.newOutputStream(Paths.get("clients.ser")));
		}
		catch (IOException iOException)
		{
			System.err.println("Error opening file. Terminating.");
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
				Account record = new Account(
					input.nextInt(), input.next(), input.next(), input.nextDouble());
				
				output.writeObject(record);
			}
			catch (NoSuchElementException elementException)
			{
				System.err.println("Invalid input. Please try again.");
				input.nextLine();
			}
			catch (IOException iOException)
			{
				System.err.println("Error writing to file. Terminating.");
				break;
			}
			catch (IllegalArgumentException argumentException)
			{
				System.err.println("Error initializing object. Terminating.");
				break;
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
		catch (IOException e)
		{
			System.err.println("Error closing file. Terminating");
		}
	}
	
	public static void main(String[] args)
	{
		openFile();
		addRecords();
		closeFile();
	}
}
