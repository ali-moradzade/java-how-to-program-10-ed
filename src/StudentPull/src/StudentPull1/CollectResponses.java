package StudentPull1;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CollectResponses
{
	private static Formatter output;
	
	public static void openFile()
	{
		try
		{
			output = new Formatter("numbers.txt");
		}
		catch (SecurityException securityException)
		{
			System.err.println(
				"Write permission denied for \"numbers.txt\". Terminating.");
			securityException.printStackTrace(System.out);
			System.exit(1);
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening \"numbers.txt\". Terminating.");
			fileNotFoundException.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	public static void addRecords()
	{
		Scanner input = new Scanner(System.in);
		System.out.printf("%s%n%s%n? ",
			"Enter your response (1: best, 5: worst).",
			"Enter end-of-file indicator to end input.");

		while (input.hasNext())
		{
			try
			{
				int response = input.nextInt();
				
				if (response < 1 || response > 5)
					throw new IllegalArgumentException(
						"Invalid response. Please try again.");
				
				output.format("%d%n", response);
			}
			catch (FormatterClosedException formatterClosedException)
			{
				System.err.println("Error writing to \"numbers.txt\". Terminating.");
				formatterClosedException.printStackTrace(System.out);
				System.exit(1);
			}
			catch (IllegalArgumentException argumentException)
			{
				System.out.printf(
					"%nYour response must be in range 1-5. Please try again.%n");
			}
			catch (NoSuchElementException elementException)
			{
				System.out.printf("%nInvalid input. Please try again.%n");
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
	
	private static boolean validateResponse(int response)
	{
		return !((response < 1) || (response > 5));
	}
	
	public static void main(String[] args)
	{
		openFile();
		addRecords();
		closeFile();
	}
}
