import java.util.Scanner;

public class FindingLargestNumber
{
	private static final int	LENGTH_OF_NUMBERS = 10;
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int count = 2;
		
		System.out.print("Enter the number: ");
		double largest = input.nextDouble();
		
		while (count <= LENGTH_OF_NUMBERS)
		{
			System.out.print("Enter the number: ");
			double number = input.nextDouble();
			
			if (number > largest)
				largest = number;
			
			count++;
		}
		
		System.out.printf("Largest number is %.2f%n", largest);
	}
}
