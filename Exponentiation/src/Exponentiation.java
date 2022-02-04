import java.util.Scanner;

public class Exponentiation
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an integer base: ");
		int base = input.nextInt();
		
		System.out.print("Enter an integer exponent: ");
		int exponent = input.nextInt();
		
		System.out.printf("Ingeter power is %d%n", integerPower(base, exponent));
	}
	
	public static int integerPower(int base, int exponent)
	{
		int result = 1;
		
		for (int i = 0; i < exponent; i++)
		{
			result *= base;
		}
		
		return result;
	}
}
