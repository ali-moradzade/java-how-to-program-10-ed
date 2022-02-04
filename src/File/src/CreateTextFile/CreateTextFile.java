package CreateTextFile;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile
{
	private static Formatter output;
	
	public static void openFile()
	{
		try
		{
			output = new Formatter("clients.txt");
		}
		catch (SecurityException securityException)
		{
			System.err.println("Write permission denied. Terminating.");
			System.exit(1);
		}
		catch (FileNotFoundException fileNotFoundException)
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
			"Enter end-of-file indicator to end input.");
		
		while (input.hasNext())
		{
			try
			{
				output.format("%d %s %s %.2f%n",
					input.nextInt(), input.next(), input.next(), input.nextDouble());
			}
			catch (FormatterClosedException formatterClosedException)
			{
				System.err.println("Error writing to file. Terminating.");
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
   
