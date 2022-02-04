import java.util.Scanner;

public class GreatestCommonDivisor
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first number (or -1 to end input): ");
		int number1 = input.nextInt();
		
		while (number1 != -1)
		{
			System.out.print("Enter second number: ");
			int number2 = input.nextInt();
		
			System.out.printf("greatest common divisor of two numbers is %d%n",
				gcd(number1, number2));
			
			System.out.printf("%nEnter first number (or -1 to end input): ");
			number1 = input.nextInt();
		}
	}
	
	public static int gcd(int number1, int number2)
	{
		if (number1 == 0 || number2 == 0)
			return 0;
		
		if (number2 > number1)
		{
			int temp = number1;
			number1 = number2;
			number2 = temp;
		}
		
		while (number2 != 0)
		{
			int temp = number1;
			number1 = number2;
			number2 = temp % number2;
		}
		
		return number1;
	}
}
