import java.util.Scanner;

public class BarChartPrinting
{
	public static void main(String[] args)
	{
		int firstNumber = inputData();
		int secondNumber = inputData();
		int thirdNumber = inputData();
		int fourthNumber = inputData();
		int fifthNumber = inputData();
		
		System.out.println();
		printBar(firstNumber);
		printBar(secondNumber);
		printBar(thirdNumber);
		printBar(fourthNumber);
		printBar(fifthNumber);
	}
	
	public static int inputData()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number: ");
		return input.nextInt();
	}
	
	public static void printBar(int number)
	{
		System.out.printf("%2d: ", number);
		
		for (int i = 0; i < number; i++)
		{
			System.out.print("*");
		}
		
		System.out.println();
	}
}
