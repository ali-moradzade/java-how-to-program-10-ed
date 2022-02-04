import java.util.Scanner;

public class DiamondPrinting
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		diamondPrinter(input.nextInt());
	}
	
	public static void diamondPrinter(int side)
	{
		for (int row = 1; row <= (side + 1) / 2; row++)
		{
			for (int space = 1; space <= side / 2 - row + 1; space++)
			{
				System.out.print(" ");
			}
			
			for (int star = 1; star <= 2 * row - 1; star++)
			{
				System.out.print("*");
			}
			
			for (int space = 1; space <= side / 2 - row + 1; space++)
			{
				System.out.print(" ");
			}
			
			for (int space = 1; space <= side / 2 - row + 1; space++)
			{
				System.out.print(" ");
			}
			
			for (int star = 1; star <= 2 * row - 1; star++)
			{
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		for (int row = 1; row <= (side - 1) / 2; row++)
		{
			for (int space = 1; space <= row; space++)
				System.out.print(" ");
			
			for (int star = 1; star <= side - 2 * row; star++)
				System.out.print("*");
			
			for (int space = 1; space <= row; space++)
				System.out.print(" ");
			
			for (int space = 1; space <= row; space++)
				System.out.print(" ");
			
			for (int star = 1; star <= side - 2 * row; star++)
				System.out.print("*");
			
			System.out.println();
		}
	}
}
