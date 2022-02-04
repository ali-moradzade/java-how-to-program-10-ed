import java.util.Scanner;

public class FindSmallest
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of values: ");
		int number = input.nextInt();
		int smallest = -1;
		
		for (int i = 0; i < number; i++)
		{
			System.out.print("Enter value: ");
			int value = input.nextInt();
			
			if (i == 0)
				smallest = value;
			else
			{
				if (value < smallest)
					smallest = value;
			}
		}
		
		System.out.printf("%nSmalles value is %d%n", smallest);
	}
}
