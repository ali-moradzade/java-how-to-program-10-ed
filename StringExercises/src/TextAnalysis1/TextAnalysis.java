package TextAnalysis1;

import java.util.Scanner;

public class TextAnalysis
{
	private static final int MAX_LENGTH = 3;
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a line of text:");
		String line = input.nextLine();
		
		int[] stringLengths = processWordLengths(line);
		
		System.out.printf("%nSummary of word lengths:%n");
		display(stringLengths);
	}
	
	public static int[] processWordLengths(String line)
	{
		String[] tokens = line.trim().split("\\s+");
		int[] stringLengths = new int[MAX_LENGTH];
		
		for (String token : tokens)
		{
			if (token.length() < MAX_LENGTH)
				stringLengths[token.length() - 1]++;
			else
				stringLengths[MAX_LENGTH - 1]++;
		}
		
		return stringLengths;
	}
	
	public static void display(int[] stringLengths)
	{
		System.out.printf("%s%15s%n", "Word length:","Occurrences:");
		
		for (int i = 0; i < stringLengths.length - 1; i++)
		{
			System.out.printf("%12d%15d%n", i + 1, stringLengths[i]);
		}
		
		System.out.printf("%10s%2d%15d%n",
			MAX_LENGTH < 10 ? "more than" : "more than ", 
			MAX_LENGTH, stringLengths[MAX_LENGTH - 1]);
	}
}
