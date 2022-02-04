import java.util.Scanner;

public class Cryptography
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a four-digit number for encrypting: ");
		int number1 = input.nextInt();
		
		System.out.printf("encypted number is %d%n", encrypt(number1));
		
		System.out.print("Enter a four-digit number for decrypting: ");
		int number2 = input.nextInt();
		
		System.out.printf("decrypted number is %d%n", decrypt(number2));
	}
	
	public static int encrypt(int number)
	{
		int firstDigit = number % 10;
		number /= 10;
		firstDigit = (firstDigit + 7) % 10;
		
		int secondDigit = number % 10;
		number /= 10;
		secondDigit = (secondDigit + 7) % 10;
		
		int thirdDigit = number % 10;
		number /= 10;
		thirdDigit = (thirdDigit + 7) % 10;
		
		int fourthDigit = number % 10;
		fourthDigit = (fourthDigit + 7) % 10;
		
		return (firstDigit * 100) + (thirdDigit) + (secondDigit * 1000) + 
			(fourthDigit * 10);
	}
	
	public static int decrypt(int number)
	{
		int firstDigit = number % 10;
		number /= 10;
		firstDigit = (firstDigit + 3) % 10;
		
		int secondDigit = number % 10;
		number /= 10;
		secondDigit = (secondDigit + 3) % 10;
		
		int thirdDigit = number % 10;
		number /= 10;
		thirdDigit = (thirdDigit + 3) % 10;
		
		int fourthDigit = number % 10;
		fourthDigit = (fourthDigit + 3) % 10;
		
		return (fourthDigit * 10) + (secondDigit * 1000) + (firstDigit * 100) +
			(thirdDigit);
	}
}
