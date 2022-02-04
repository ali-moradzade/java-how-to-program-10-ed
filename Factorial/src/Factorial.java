import java.util.Scanner;

public class Factorial
{
	private static final int LENGTH_OF_SECTIONS = 30;
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a positive integer: ");
		int number = input.nextInt();
		
		System.out.printf("Factorial of number is: %d%n%n", factorial(number));
		System.out.printf("E with %d secitons is %f%n%n", 
			LENGTH_OF_SECTIONS, getNeper());
		
		System.out.print("Enter the number for the e to the power of number: ");
		int value = input.nextInt();
		
		System.out.printf("e to the power of %d is %f%n",
			value, neperToThePowerOfX(value));
	}
	
	public static long factorial(int number)
	{
		if (number <= 1)
			return 1;
		else
		{
			int result = 1;
			
			for (int i = 1; i <= number; i++)
				result *= i;
			
			return result;
		}
	}
	
	public static double getNeper()
	{
		double neper = 0;
		
		for (int count = 0; count < LENGTH_OF_SECTIONS; count++)
		{
			neper += 1.0 / factorial(count);
		}
		
		return neper;
	}
	
	public static double neperToThePowerOfX(int x)
	{
		double result = 0;
		
		for (int i = 0; i < LENGTH_OF_SECTIONS; i++)
		{
			result += Math.pow(x, i) / factorial(i);
		}
		
		return result;
	}
}
