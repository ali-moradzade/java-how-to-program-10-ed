package palindrome;

import java.util.Scanner;

public class Palindrome
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a line of text for checking for palindrome:");
		String line = input.nextLine();
		
		System.out.printf("This string %s palindrome.%n",
			checkPalindrome(cleanWord(line)) ? "is" : "is not");
	}
	
	private static String cleanWord(String word)
	{
		return word.replaceAll("[^a-zA-Z0-9]","");
	}
	
	private static boolean isPalindrome(final char[] chars, final int from,
        final int to) 
	{
		if (from > to)
			return true;
		else
			return chars[from] != chars[to] ? false :
				isPalindrome(chars, from + 1, to - 1);
	}
	
	private static boolean isPalindrome1(String word)
	{
		int length = word.length();

		for (int i = 0; i <= length / 2; i++)
		{
			if (word.charAt(i) != word.charAt(length - 1 - i))
				return false;
		}

		return true;
	}
	
	private static boolean checkPalindrome(String word) 
	{
		if (word.length() <= 1)
			return true;

		char first = word.charAt(0);
		char last = word.charAt(word.length() - 1);

		if (first != last)
			return false;
		else
			return checkPalindrome(word.substring(1, word.length() - 1));
	}
}