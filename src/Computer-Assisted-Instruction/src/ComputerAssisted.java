import java.util.Scanner;
import java.util.Random;

public class ComputerAssisted
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		while (true)
		{
			int result = makeQuestion();
			int studentAnswer = input.nextInt();
			
			while (studentAnswer != result)
			{
				System.out.printf("%s%n? ", "No. Please try again.");
				studentAnswer = input.nextInt();
			}
			
			System.out.printf("Very good!%n%n");
		}
	}
	
	public static int makeQuestion()
	{
		Random randomNumbers = new Random();
		
		int number1 = 1 + randomNumbers.nextInt(100);
		int number2 = 1 + randomNumbers.nextInt(100);
		
		System.out.printf("How much is %d times %d? ", number1, number2);
		
		return number1 * number2;
	}
}
