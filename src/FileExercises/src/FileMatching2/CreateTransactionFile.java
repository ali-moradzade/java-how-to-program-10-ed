package FileMatching2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTransactionFile
{
	private static ObjectOutputStream output;
	
	public static void openFile()
	{
		try
		{
			output = new ObjectOutputStream(
				Files.newOutputStream(Paths.get("trans.ser")));
		}
		catch (IOException iOException)
		{
			System.err.println("Error writing to \"trans.ser\". Terminating.");
			iOException.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	public static void addRecords()
	{
		Scanner input = new Scanner(System.in);
		System.out.printf("%s%n%s%n? ",
			"Enter account number and amount.",
			"Enter end-of-file indicator to end input.");
		
		while (input.hasNext())
		{
			try
			{
				TransactionRecord record = new TransactionRecord(input.nextInt(), 
					input.nextDouble());
				
				output.writeObject(record);
			}
			catch (NoSuchElementException elementException)
			{
				System.err.println(
					"File \"trans.txt\" formed improperly. Terminating.");
				elementException.printStackTrace(System.out);
				System.exit(1);
			}
			catch (IOException iOException)
			{
				System.err.println("Error writing to \"trans.ser\". Terminating.");
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
		catch (IOException e)
		{
			System.err.println("Error closing \"trans.ser\". Terminating.");
			e.printStackTrace(System.out);
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
