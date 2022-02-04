import java.util.Scanner;

public class SidesOfARightTriangle
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter three number separated by spaces: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
		
		if ((number1 * number1 + number2 * number2 == number3 * number3) ||
			(number3 * number3 + number2 * number2 == number1 * number1) ||
			(number1 * number1 + number3 * number3 == number2 * number2))
			System.out.println("Three number can make a right triangle.");
		else
			System.out.println("Three number can not make a triangle.");
	}
}
