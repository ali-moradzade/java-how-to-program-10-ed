package DivideByZero.NoExceptionHandling;

import java.util.Scanner;

public class DivideByZero
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter an integer numerator: ");
		int numerator = scanner.nextInt();
		
		System.out.print("Please enter an integer denominator: ");
		int denominator = scanner.nextInt();
		
		int result = quotient(numerator, denominator);
		System.out.printf("%n%s: %d / %d = %d%n", 
			"Result", numerator, denominator, result);
	}
	
	public static int quotient(int numerator, int denominator)
	{
		return numerator / denominator;
	}
}
