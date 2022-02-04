import java.util.Scanner;

public class SidesOfTriangle
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter three integers separated by space: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
		
		if (number1 + number1 > number3 && number1 + number3 > number2 &&
			 number2 + number3 > number1)
			System.out.println("Three numbers entered can make a triangle.");
		else
			System.out.println("Three numbers entered can not make a triangle.");
	}
}
