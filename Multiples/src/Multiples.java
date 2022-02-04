import java.util.Scanner;

public class Multiples
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter frist integer: ");
		int number1 = input.nextInt();
		
		System.out.print("Enter second integer(except zero): ");
		int number2 = input.nextInt();
		
		if (number2 != 0)
			if (number1 % number2 == 0)
				System.out.println("First integer is a multipe of second integer.");
		
		if (number2 != 0)
			if (number1 % number2 != 0)
				System.out.println("First integer is not a multiple of second integer.");
	}
}
