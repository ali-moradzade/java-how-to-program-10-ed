import java.util.Scanner;

public class AsteriskSquare
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the size of square: ");
		int size = input.nextInt();
		
		int row = 1;
		
		while (row <= size)
		{
			int col = 1;
			
			while (col <= size)
			{
				System.out.print("* ");
				col++;
			}
			
			System.out.println();
			row++;
		}
	}
}
