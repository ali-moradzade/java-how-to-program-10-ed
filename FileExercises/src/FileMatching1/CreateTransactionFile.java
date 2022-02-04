package FileMatching1;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTransactionFile
{
	private static Formatter output;
	
	public static void openFile()
	{
		try
		{
			output = new Formatter("trans.txt");
		}
		catch (SecurityException securityException)
		{
			System.err.println(
				"Write permission denied for \"trans.txt\". Terminating.");
			securityException.printStackTrace(System.out);
			System.exit(1);
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error openind \"trans.txt\" file. Terminating.");
			fileNotFoundException.printStackTrace(System.out);
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
				output.format("%d %,.2f%n", input.nextInt(), input.nextDouble());
			}
			catch (FormatterClosedException formatterClosedException)
			{
				System.err.println(
					"Error writing to \"trans.txt\" file. Terminating.");
				formatterClosedException.printStackTrace(System.out);
				System.exit(1);
			}
			catch (NoSuchElementException elementException)
			{
				System.err.println(
					"File \"trans.txt\" formed improperly. Terminating.");
				elementException.printStackTrace(System.out);
				System.exit(1);
			}
			
			System.out.print("? ");
		}
	}
	
	public static void closeFile()
	{
		if (output != null)
			output.close();
	}
	
	public static void main(String[] args)
	{
		openFile();
		addRecords();
		closeFile();
	}
}
