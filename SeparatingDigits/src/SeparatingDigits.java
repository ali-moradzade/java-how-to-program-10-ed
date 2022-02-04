import java.util.Scanner;

public class SeparatingDigits
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
//		System.out.print("Enter a five-digit integer: ");
//		int number = input.nextInt();
//		
//		int firstDigit = number % 10;
//		number = number / 10;
//		
//		int secondDigit = number % 10;
//		number = number / 10;
//		
//		int thirdDigit = number % 10;
//		number = number / 10;
//		
//		int fourthDigit = number % 10;
//		number = number / 10;
//		
//		int fifthDigit = number % 10;
//		
//		System.out.printf("%d   %d   %d   %d   %d%n%n",
//			fifthDigit, fourthDigit, thirdDigit, secondDigit, firstDigit);
		
		System.out.print("Enter a number: ");
		int number = input.nextInt();
		
		System.out.println("Separated number is:");
		
		while (number > 0)
		{
			System.out.print(number % 10);
			number /= 10;
		}
		
		System.out.println();
	}
	
	private static int[] separateDigits(int number)
	{
		int count = 0;
		int numberLength = 1 + (int) Math.log(number);
		
		int[] digits = new int[numberLength];
		
		while (number > 0)
		{
			digits[count] = number % 10;
			number /= 10;
			count++;
		}
		
		return digits;
	}
}
