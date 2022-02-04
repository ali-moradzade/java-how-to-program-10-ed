package ComparingPortionsOfStrings;

import java.util.Scanner;

public class CompareIgnoreCase
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter first string for compare with case ignoration:");
		String first = input.nextLine();
		
		System.out.println("Enter second string:");
		String second = input.nextLine();
		
		System.out.print("Enter the starting index for compare: ");
		int start = input.nextInt();
		
		System.out.print("Enter number of characters: ");
		int count = input.nextInt();
		
		boolean result = first.regionMatches(true, start, second, start, count);
		System.out.printf("%n\"%s\" and \"%s\" %s match in specific region.%n",
			first, second, result ? "" : "do not match");
	}
}
