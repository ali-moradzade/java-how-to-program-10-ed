import java.util.Scanner;

public class Multiple
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first intger (or -1 to end input): ");
		int firstNumber = input.nextInt();
		
		while (firstNumber != -1)
		{
			System.out.print("Enter second integer: ");
			int secondNumber = input.nextInt();
			
			System.out.printf("The second number %s multiple of first number.%n%n",
				(isMultiple(firstNumber, secondNumber) ? "is" : "isn't"));
			
			System.out.print("Enter first intger (or -1 to end input): ");
			firstNumber = input.nextInt();
		}
	}
	
	public static boolean isMultiple(int firstNumber, int secondNumber)
	{
		return (secondNumber % firstNumber == 0);
	}
}
