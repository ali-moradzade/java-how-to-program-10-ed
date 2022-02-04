package TextAnalysis;

import java.util.Scanner;

public class TextAnalysis
{
	private static final String characters = "abcdefghijklmnopqrstuvwxyz";
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a line of text:");
		String line = input.nextLine();
		
		int[] chars = analyseLineCharacters(line);
		
		System.out.printf("%nProcessed line has the characters as below:%n");
		display(chars);
	}
	
	public static int[] analyseLineCharacters(String line)
	{
		String[] tokens = line.trim().split("\\s+");
		int[] chars = new int[characters.length()];
		
		for (String token : tokens)
		{
			determineCharacters(token, chars);
		}
		
		return chars;
	}
	
	private static void determineCharacters(String string, int[] chars)
	{
		for (int i = 0; i < characters.length(); i++)
		{
			chars[i] += searchForChar(string, characters.charAt(i));
		}
	}
	
	private static int searchForChar(String string, char character)
	{
		int count = 0;
		int index = -1;
		
		for (int i = 0; i < string.length(); i++)
		{
			int number = string.indexOf(character, index + 1);
			
			if (number < 0)
				break;
			else
			{
				count++;
				index = number;
			}
		}
		
		return count;
	}
	
	public static void display(int[] chars)
	{
		for (int i = 0; i < chars.length; i++)
		{
			System.out.printf("%s,%s: %d%s",
				characters.charAt(i), Character.toUpperCase(characters.charAt(i)),
				chars[i], i % 2 == 0 ? "\t" : "\n");
		}
	}
}
