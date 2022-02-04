package ComparingStrings;

import java.util.Scanner;

public class ComparingStrings
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter first sring for compare:");
		String firstString = input.nextLine();
		
		System.out.println("Enter second string for compare:");
		String secondString = input.nextLine();
		
		int result = firstString.compareTo(secondString);
		
		System.out.println();
		
		if (result < 0)
			System.out.printf("\"%s\" is greater than \"%s\"%n",
				secondString, firstString);
		else if (result == 0)
			System.out.printf("\"%s\" is equal to \"%s\"%n",
				firstString, secondString);
		else
			System.out.printf("\"%s\" is greater than \"%s\"%n",
				firstString, secondString);
	}
}
