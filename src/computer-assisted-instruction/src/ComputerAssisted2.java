import java.util.Scanner;
import java.util.Random;

public class ComputerAssisted2
{
	private static final Random randomNumbers = new Random();
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int corrects = 0;
		int wrongs = 0;
		boolean flag = true;
		
		while (corrects + wrongs < 3)
		{
			int result = makeQuestion();
			int studentAnswer = input.nextInt();
			
			while (studentAnswer != result)
			{
				wrongs++;
				
				System.out.printf("%s%n? ", showWrongDescription());
				studentAnswer = input.nextInt();
				
				if (corrects + wrongs == 3)
				{
					showInstructionResults(corrects, wrongs);
					flag = false;
					break;
				}
			}
			
			if (flag)
			{
				System.out.printf("%s%n%n", showCorrectDescription());
				corrects++;
			}
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
	
	public static void showInstructionResults(int corrects, int wrongs)
	{
		if ((double) corrects / 10 >= 75.00)
			System.out.print("Congratulatoins, you are ready to go the next leverl.");
		else
			System.out.print("Please ask your teacher for extra help.");
		
		System.out.printf(" (corrects: %d, wrongs: %d)%n", corrects, wrongs);
	}
}
