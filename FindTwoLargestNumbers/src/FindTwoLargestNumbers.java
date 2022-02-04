import java.util.Scanner;

public class FindTwoLargestNumbers
{
	private static final int LENGTH_OF_NUMBER = 5;
		
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int numberCounter = 3;
		
		System.out.print("Enter the number: ");
		int largest = input.nextInt();
		
		System.out.print("Enter the number: ");
		int secondLargest = input.nextInt();
		
		if (secondLargest > largest)
		{
			int temp = largest;
			largest = secondLargest;
			secondLargest = temp;
		}
		
		while (numberCounter <= LENGTH_OF_NUMBER)
		{
			System.out.print("Enter the number: ");
			int number = input.nextInt();
			
			if (number > largest)
			{
				secondLargest = largest;
				largest = number;
			}
			else if (number > secondLargest)
			{
				secondLargest = number;
			}
			
			numberCounter++;
		}
		
		System.out.printf("%n%s%d%n%s%d%n",
			"Largest number: ", largest,
			"Second largest number: ", secondLargest);
	}
}
