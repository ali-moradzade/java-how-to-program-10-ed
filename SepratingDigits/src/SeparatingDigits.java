import java.util.Scanner;

public class SeparatingDigits
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an integer number: ");
		int number = input.nextInt();
		
		System.out.printf("Separated number is %s%n", separateDigits(number));
	}
	
	public static String separateDigits(int number)
	{
		String result = "";
		
		while (number > 0)
		{
			result = number % 10 + " " + result;
			number /= 10;
		}
		
		return result;
	}
}
