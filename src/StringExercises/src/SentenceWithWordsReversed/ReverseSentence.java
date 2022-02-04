package SentenceWithWordsReversed;

import java.util.Scanner;

public class ReverseSentence
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a line of text:");
		String text = input.nextLine();
		
		String[] tokens = text.trim().split(" ");
		
		System.out.printf("%nTokens in reverse order are:%n");
		
		for (String token : tokens)
		{
			StringBuilder buffer = new StringBuilder(token);
			System.out.println(buffer.reverse());
		}
	}
}
