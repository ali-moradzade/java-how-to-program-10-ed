package primenumber1;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

public class PrimeNumber
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.printf("%s%n%s%n? ",
			"Enter a positive integer for checking.",
			"Enter end-of-file indicator to end input");
		
		while (input.hasNext())
		{
			try
			{
				int number = input.nextInt();
				
				if (number <= 0)
					throw new IllegalArgumentException(
						"Negative or zero number (" + number + ")");

				System.out.printf("%-9s%-12s%-17s%n",
					"Number", "Is Prime", "Factors");

				if (isPrime(number))
				{
					System.out.printf("%-9d%-12s%-17s%n", 
						number, "true", "-----");
				}
				else
				{
					System.out.printf("%-9d%-12s",
						number, "false");

					TreeSet<Integer> set = findFactors(number);

					for (Integer integer : set)
					{
						System.out.printf("%d ", integer);
					}

					System.out.println();
				}
			}
			catch (NoSuchElementException elementException)
			{
				System.out.println("Invalid input. Please try again.");
				input.nextLine();
			}
			catch (IllegalArgumentException argumentException)
			{
				System.out.printf("Ivalid number: %s%n",
					argumentException.getMessage());
				System.out.println("Please try again.");
			}
			
			System.out.print("? ");
		}
	}
	
	private static TreeSet<Integer> findFactors(int number)
	{
		TreeSet<Integer> set = new TreeSet<>();
		
		if (number == 1)
		{
			set.add(1);
			
			return set;
		}
		
		for (int count = 2; count < number / 2 + 1; count++)
		{
			if (number % count == 0)
			{
				if (isPrime(count))
					set.add(count);
			}
		}
		
		return set;
	}
	
	private static boolean isPrime(int number)
	{
		if (number == 1)
			return false;
		
		for (int count = 2; count < (int) Math.sqrt(number) + 1; count++)
			if (number % count == 0)
				return false;
		
		return true;
	}
}
