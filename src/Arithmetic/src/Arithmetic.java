import java.util.Scanner;

public class Arithmetic
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
		int number1 = input.nextInt();
		
		System.out.print("Enter second integer: ");
		int number2 = input.nextInt();
		
		System.out.printf("Sum: %d%n", (number1 + number2));
		System.out.printf("Product: %d%n", (number1 * number2));
		System.out.printf("Difference: %d%n", (number1 - number2));
		
		if (number2 != 0)
			System.out.printf("Quotient: %d%n", (number1 / number2));
	}
}
