package recursivepowermethod;

import java.util.Scanner;

public class Power
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a base and exponent: ");
		int base = input.nextInt();
		int exponent = input.nextInt();
		
		System.out.printf("%d to power of %d is: %d%n",
			base, exponent, power(base, exponent));
	}
	
	public static int power(int base, int exponent)
	{
		if (exponent == 1)
			return base;
		else
			return base * power(base, exponent - 1);
	}
}
