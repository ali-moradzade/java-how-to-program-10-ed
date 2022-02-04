import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Random randomNumbers = new Random();
		int tryTimes = 1;
		
		int number = 1 + randomNumbers.nextInt(1000);
		
		System.out.print("Enter your number: ");
		int value = input.nextInt();
		
		while (value != number)
		{
			if (value > number)
				System.out.println("Too high. tray again.");
			else
				System.out.println("Too low. tray again.");
			
			tryTimes++;
			
			System.out.printf("%nEnter your number: ");
			value = input.nextInt();
		}
		
		System.out.printf("%n%s%n%s%d%s%n",
			"Congratulatoins. You guessed the number!",
			"your succesed in ", tryTimes," tries.");
	}
}
