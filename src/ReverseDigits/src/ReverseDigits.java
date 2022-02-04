import java.util.Scanner;

public class ReverseDigits
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an integer number (and -1 to end input): ");
		int number = input.nextInt();
		
		while (number != -1)
		{
			System.out.printf("Reversed number is %d%n", reverse(number));
			
			System.out.print("Enter an integer number (and -1 to end input): ");
			number = input.nextInt();
		}
	}
	
	public static int reverse(int number)
	{
		int reversedNumber = 0;
		
		while (number > 0)
		{
			int rightMostDigit = number % 10;
			reversedNumber =  reversedNumber * 10 + rightMostDigit;
			
			number /= 10;
		}
		
		return reversedNumber;
	}
}
