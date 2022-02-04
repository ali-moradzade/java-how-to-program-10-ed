package TokenizingAndComparingStrings1;

import java.util.Scanner;

public class TokenizeAndCompare
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a line of text:");
		String text = input.nextLine();
		
		String[] tonkensEndWithED = tokenizseAndCompare(text);
		
		System.out.printf("%nTokens that start with with letter e and d:%n");
		
		for (String token : tonkensEndWithED)
		{
			System.out.println(token);
		}
	}
	
	public static String[] tokenizseAndCompare(String text)
	{
		String[] tokens = text.trim().split(" ");
		String[] tokensToTest = new String[tokens.length];
		int count = 0;
		
		for (int i = 0; i < tokens.length; i++)
		{
			int length = tokens[i].length();
			
			if (length >= 2 && tokens[i].substring(length - 2).equalsIgnoreCase("ed"))
			{
				tokensToTest[count] = tokens[i];
				count++;
			}
		}
		
		String[] result = new String[count];
		
		System.arraycopy(tokensToTest, 0, result, 0, count);
		
		return result;
	}
}
