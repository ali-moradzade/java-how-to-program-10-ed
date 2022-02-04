import java.util.Scanner;

public class RectangleTest
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter width of the rectangle in range 0-20 (-1 ot end input): ");
		double width = input.nextDouble();
		
		while (width >= 0)
		{
			System.out.print("Enter the length of the rectangle in range 0-20 (-1 ot end input): ");
			double length = input.nextDouble();
			
			try
			{
				Rectangle rectangle = new Rectangle(length, width);
				displayInformation(rectangle);
			}
			catch (IllegalArgumentException e)
			{
				System.out.printf("%n%s%n%n", e.getMessage());
			}
			
			System.out.print("Enter width of the rectangle in range 0-20 (-1 ot end input): ");
			width = input.nextDouble();
		}
	}
	
	public static void displayInformation(Rectangle rectangle)
	{
		System.out.printf("Rectangle created:%n%s%n%n", rectangle);
	}
}
