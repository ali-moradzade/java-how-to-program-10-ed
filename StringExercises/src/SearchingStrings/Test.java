package SearchingStrings;

import java.util.Scanner;

public class Test
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a line of text:");
		String text = input.nextLine();
		
		System.out.print("Enter a character to search for it in text: ");
		char character = input.next().charAt(0);
		
		System.out.printf("%nNumber of occurrences of characer in the text is: %d%n",
			searchForChar(text, character));
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
}
