import java.util.Scanner;
import java.util.Random;

public class ComputerAssisted1
{
	private static final Random randomNumbers = new Random();
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		while (true)
		{
			int result = makeQuestion();
			int studentAnswer = input.nextInt();
			
			while (studentAnswer != result)
			{
				System.out.printf("%s%n? ", showWrongDescription());
				studentAnswer = input.nextInt();
			}
			
			System.out.printf("%s%n%n", showCorrectDescription());
		}
	}
	
	public static int makeQuestion()
	{
		int number1 = 1 + randomNumbers.nextInt(100);
		int number2 = 1 + randomNumbers.nextInt(100);
		
		System.out.printf("How much is %d times %d? ", number1, number2);
		
		return number1 * number2;
	}
	
	public static String showCorrectDescription()
	{
		int number = 1 + randomNumbers.nextInt(4);
		String result = "";
		
		switch (number)
		{
			case 1:
				result = "Very good!";
				break;
			case 2:
				result = "Excellent!";
				break;
			case 3:
				result = "Nice work!";
			case 4:
				result = "Keep up good work!";
				break;
		}
		
		return result;
	}
	
	public static String showWrongDescription()
	{
		int number = 1 + randomNumbers.nextInt(4);
		String result = "";
		
		switch (number)
		{
			case 1:
				result = "No. Please try again.";
				break;
			case 2:
				result = "Wrong. Try once more.";
				break;
			case 3:
				result = "Don't give up!";
			case 4:
				result = "No. keep trying.";
				break;
		}
		
		return result;
	}
}
