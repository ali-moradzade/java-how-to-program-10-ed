package square;

import java.util.Scanner;

public class DisplayingSquareOfAstresiks
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the side of square: ");
		int side = input.nextInt();
		
		System.out.print("Enter a character to draw square with: ");
		char fill = input.next().charAt(0);
		
		drawSquare(side, fill);
	}
	
	public static void drawSquare(int side, char fill)
	{
		for (int i = 0; i < side; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				System.out.print(fill);
			}
			
			System.out.println();
		}
	}
}
