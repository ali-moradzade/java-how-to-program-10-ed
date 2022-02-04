package SearchingStrings1;

import java.util.Scanner;

public class SearchingForAllLetters
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String characters = "abcdefghijklmnopqrstuvwxyz";
		int[] counterArray = new int[characters.length()];
		
		System.out.println("Enter a line of tex:");
		String text = input.nextLine();
		
		for (int i = 0; i < characters.length(); i++)
		{
			char lowerCase = Character.toLowerCase(characters.charAt(i));
			char upperCase = Character.toUpperCase(lowerCase);
			counterArray[i] += searchForChar(text, lowerCase);
			counterArray[i] += searchForChar(text, upperCase);
		}
		
		display(characters, counterArray);
	}
	
	public static int searchForChar(String text, char character)
	{
		int count = 0;
		int index = -1;
		
		for (int i = 0; i < text.length(); i++)
		{
			int number = text.indexOf(character, index + 1);
			
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
	
	private static void display(String characters, int[] count)
	{
		for (int i = 0; i < characters.length(); i++)
		{
			char lowerCase = Character.toLowerCase(characters.charAt(i));
			char upperCase = Character.toUpperCase(lowerCase);
			
			System.out.printf("%c,%c: %d%s", 
				lowerCase, upperCase, count[i], (i % 2 == 0) ? "\t" : "\n");
		}
	}
}
