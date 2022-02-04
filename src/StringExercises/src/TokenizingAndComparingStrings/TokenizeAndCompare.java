package TokenizingAndComparingStrings;

import java.util.Scanner;

public class TokenizeAndCompare
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a line of text:");
		String text = input.nextLine();
		
		String[] tokensStartedWithB = tokenizseAndCompare(text);
		
		System.out.printf("%nTokens that start with with B(b):%n");
		
		for (String token : tokensStartedWithB)
		{
			System.out.println(token);
		}
	}
	
	public static String[] tokenizseAndCompare(String text)
	{
		String[] tokens = text.trim().split(" ");
		String[] toknesWithB = new String[tokens.length];
		int count = 0;
		
		for (int i = 0; i < tokens.length; i++)
		{
			if (Character.toLowerCase(tokens[i].charAt(0)) == 'b')
			{
				toknesWithB[count] = tokens[i];
				count++;
			}
		}
		
		String[] result = new String[count];
		
		for (int i = 0; i < count; i++)
		{
			result[i] = toknesWithB[i];
		}
		
		return result;
	}
}
