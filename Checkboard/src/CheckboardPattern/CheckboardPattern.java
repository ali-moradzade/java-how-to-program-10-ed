package CheckboardPattern;

public class CheckboardPattern
{
	private static final int SIDE_OF_CHECKBORAD = 10;
		
	public static void main(String[] args)
	{
		int row = 1;
		
		while (row <= SIDE_OF_CHECKBORAD)
		{
			if (row % 2 == 0)
				System.out.print(" ");
			
			int col = 1;
			
			while (col <= SIDE_OF_CHECKBORAD)
			{
				System.out.print("* ");
				col++;
			}
			
			System.out.println();
			row++;
		}
	}
}
