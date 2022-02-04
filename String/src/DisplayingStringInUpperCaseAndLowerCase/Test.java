package DisplayingStringInUpperCaseAndLowerCase;

import java.util.Scanner;

public class Test
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a line of text:");
		String text = input.nextLine();
		
		System.out.printf("%n%s:%n%s: %s%n%s: %s%n,",
			"Displaying text with all upper case and all lower case letters",
			"upper case", text.toUpperCase(),
			"lower case", text.toLowerCase());
	}
}
