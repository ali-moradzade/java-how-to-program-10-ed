package TelephoneNumberWordGenerator;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TelephoneNumberWordGenerator
{
	private static PrintStream output;
	
	private static int phoneNumber;
	private static final int[] digits = new int[7];
	private static final String letters = "abcdefghijklmnoprstuvwxy";
	
	public static void openFile()
	{
		try
		{
			output = new PrintStream("telephonewords.txt");
		}
		catch (SecurityException securityException)
		{
			System.err.println(
				"Write permission denied for \"telephonewords.txt\". Terminating.");
			securityException.printStackTrace(System.out);
			System.exit(1);
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println(
				"Error writing to \"telephonewords.txt\". Terminating.");
			fileNotFoundException.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	private static void addRecords()
	{
		setPhoneNumber();
		separateDigits();
		
		output.printf("Words for telephone number: %d%n%n", phoneNumber);
		int count = 1;
		
		for (int one = 0; one < 3; one++)
		{
			for (int two = 0; two < 3; two++)
			{
				for (int three = 0; three < 3; three++)
				{
					for (int four = 0; four < 3; four++)
					{
						for (int five = 0; five < 3; five++)
						{
							for (int six = 0; six < 3; six++)
							{
								for (int seven = 0; seven < 3; seven++)
								{
									StringBuilder buffer = new StringBuilder()
										.append(letters.charAt((digits[0] - 2) * 3 + one))
										.append(letters.charAt((digits[1] - 2) * 3 + two))
										.append(letters.charAt((digits[2] - 2) * 3 + three))
										.append(letters.charAt((digits[3] - 2) * 3 + four))
										.append(letters.charAt((digits[4] - 2) * 3 + five))
										.append(letters.charAt((digits[5] - 2) * 3 + six))
										.append(letters.charAt((digits[6] - 2) * 3 + seven));
									
									output.printf("%s%s",
										buffer.toString(), count % 9 == 0 ? "\n" : "\t");
									count++;
								}
							}
						}
					}
				}
			}
		}
	}
	
	private static void separateDigits()
	{
		int count = 6;
		
		while (phoneNumber > 0)
		{
			digits[count] = phoneNumber % 10;
			phoneNumber /= 10;
			count--;
		}
	}
	
	private static void setPhoneNumber()
	{
		
		Scanner input = new Scanner(System.in);
		boolean continueLoop = true;
		
		do
		{
			try
			{
				System.out.print("Enter a seven-digit phone number: ");
				phoneNumber = input.nextInt();

				if (!validatePhoneNumber())
					throw new IllegalArgumentException("Invalid phone number.");
				
				continueLoop = false;
			}
			catch (NoSuchElementException elementException)
			{
				System.out.printf("Ivalid input. Please try again.%n%n");
				input.nextLine();
			}
			catch (IllegalArgumentException argumentException)
			{
				System.out.printf("%s%n%n", argumentException.getMessage());
			}
		} while (continueLoop);
	}
	
	private static boolean validatePhoneNumber()
	{
		return	 String.valueOf(phoneNumber).matches("[2-9]{7}");
	}
	
	public static void closeFile()
	{
		if (output != null)
			output.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		openFile();
		addRecords();
		closeFile();
		
		System.out.printf("%nFile successfully created.%n");
	}
}
