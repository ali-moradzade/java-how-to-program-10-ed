import java.util.Scanner;

public class Palindrome
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an integer number: ");
		int number = input.nextInt();
		
		if (number == reverse(number))
			System.out.println("Is a palindrome!");
		else
			System.out.println("Is not a palindrome.");
	}
	
	public static int reverse(int number)
	{
		int reverse = 0;
		
		while (number > 0)
		{
			reverse *= 10;
			reverse += number % 10;
			number /= 10;
		}
		
		
		return reverse;
	}
}
