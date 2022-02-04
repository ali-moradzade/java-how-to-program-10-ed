package StudentPull1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentPull
{
	private static Scanner inNumbers;
	private static Formatter outOutput;
	
	private static final int[] frequency = new int[6];
	
	public static void openNumbers()
	{
		try
		{
			inNumbers = new Scanner(Paths.get("numbers.txt"));
		}
		catch (IOException e)
		{
			System.err.println("Error opening \"numbers.txt\". Terminating.");
			e.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	public static void openOutput()
	{
		try
		{
			outOutput = new Formatter("output.txt");
		}
		catch (SecurityException securityException)
		{
			System.err.println(
				"Write permission denied for \"output.txt\". Terminating.");
			securityException.printStackTrace(System.out);
			System.exit(1);
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Error opening \"output.txt\". Terminating.");
			e.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	public static void readRecordsFromNumbers()
	{
		try
		{
			while (inNumbers.hasNext())
			{
				try
				{
					++frequency[inNumbers.nextInt()];
				}
				catch (ArrayIndexOutOfBoundsException e)
				{
					System.err.printf("%n%s%n%s%n%n",
						"Invalid response.", e.getMessage());
				}
			}
		}
		catch (NoSuchElementException elementException)
		{
			System.err.println(
				"File \"numbers.txt\" formed improperly. Terminating.");
			elementException.printStackTrace(System.out);
			System.exit(1);
		}
		catch (IllegalStateException stateException)
		{
			System.err.println("Error reading from \"numbers.txt\". Terminating.");
			stateException.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	public static void addRecordsToOutput()
	{
		try
		{
			outOutput.format("%s%10s%n", "Rating", "Frequency");
		
			for (int rating = 1; rating < frequency.length; rating++)
			{
				outOutput.format("%6d%10d%n", rating, frequency[rating]);
			}
		}
		catch (FormatterClosedException formatterClosedException)
		{
			System.err.println("Error writing to \"output.txt\". Terminating.");
			formatterClosedException.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	public static void closeNumbers()
	{
		if (inNumbers != null)
			inNumbers.close();
	}
	
	public static void closeOutput()
	{
		if (outOutput != null)
			outOutput.close();
	}
	
	public static void main(String[] args)
	{
		openNumbers();
		openOutput();
		
		readRecordsFromNumbers();
		addRecordsToOutput();
		
		closeNumbers();
		closeOutput();
	}
}
