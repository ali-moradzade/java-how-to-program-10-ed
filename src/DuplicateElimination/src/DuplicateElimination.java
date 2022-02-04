import java.util.Scanner;


public class DuplicateElimination
{
	private static final int[] numbers = new int[5];
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		for (int counter = 1; counter <= 5; counter++)
		{
			System.out.print("Enter a number in the range 10-100: ");
			int number = input.nextInt();

			boolean put = putInNumbers(number);

			while (!put)
			{
				System.out.print(
					"Your number is duplicate please enter another number: ");
				number = input.nextInt();
				put = putInNumbers(number);
			}
			
			displayNumbers();
		}
	}
	
	public static void displayNumbers()
	{
		for (int counter = 0; counter < numbers.length && numbers[counter] != 0;
			counter++)
		{
			System.out.printf("%d ", numbers[counter]);
		}
		
		System.out.println();
	}
	
	public static boolean putInNumbers(int number)
	{
		boolean b = true;
		int location = 0;
		
		for (int i = 0; i < numbers.length && numbers[i] != 0; i++)
		{
			if (number == numbers[i])
				return false;
			
			location = i + 1;
		}
		
		numbers[location] = number;
		return true;
	}
}
