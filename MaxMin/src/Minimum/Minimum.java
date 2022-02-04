package Minimum;

import java.util.Scanner;

public class Minimum
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter three numbers seperated by spaces: ");
		double number1 = input.nextDouble();
		double number2 = input.nextDouble();
		double number3 = input.nextDouble();
		
		System.out.printf("Minimum of three numbers is %.2f%n", 
			minimum3(number1, number2, number3));
	}
	
	public static double minimum3(double number1, double number2, double number3)
	{
		return Math.min(number1, Math.min(number2, number3));
	}
}
