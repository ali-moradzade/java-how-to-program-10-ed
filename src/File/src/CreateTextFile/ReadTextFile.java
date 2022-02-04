package CreateTextFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class ReadTextFile
{
	private static Scanner input;
	
	public static void openFile()
	{
		try
		{
			input = new Scanner(Paths.get("clients.txt"));
		}
		catch (IOException iOException)
		{
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}
	
	public static void readRecords()
	{
		System.out.printf("%-10s%-12s%-12s%10s%n",
			"Account", "First Name", "Last Name", "Balance");
		
		try
		{
			while (input.hasNext())
			{
				System.out.printf("%-10d%-12s%-12s%10.2f%n",
					input.nextInt(),  input.next(), input.next(), input.nextDouble());
			}
		}
		catch (NoSuchElementException elementException)
		{
			System.err.println("File improperly formed. Terminating.");
		}
		catch (IllegalStateException stateException)
		{
			System.err.println("Error reading from file. Terminating.");
		}
	}
	
	public static void closeFile()
	{
		if (input != null)
			input.close();
	}
	
	public static void main(String[] args)
	{
		openFile();
		readRecords();
		closeFile();
	}
}
