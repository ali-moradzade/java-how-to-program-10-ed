package FileMatching1;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateOldMasterFile
{
	private static Formatter output;
	
	public static void openFile()
	{
		try
		{
			output = new Formatter("oldmast.txt");
		}
		catch (SecurityException securityException)
		{
			System.err.println(
				"Write permission denied for file \"oldmast.txt\". Terminating.");
			securityException.printStackTrace(System.out);
			System.exit(1);
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Erro opening file \"oldmast.txt\". Terminating.");
			fileNotFoundException.printStackTrace(System.out);
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
				output.format("%d %s %s %,.2f%n",
					input.nextInt(), input.next(), input.next(), input.nextDouble());
			}
			catch (FormatterClosedException formatterClosedException)
			{
				System.err.println("Error writing to file \"oldmast.txt\". Terminating.");
				formatterClosedException.printStackTrace(System.out);
				System.exit(1);
			}
			catch (NoSuchElementException elementException)
			{
				System.out.println("Invalid input. Please try again.");
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
