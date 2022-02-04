public class TripeFor
{
	private static final int TOTAL_ROW = 10;
	private static final int TOTAL_COL = 10;
	private static final int LENGTH = 10;
		
	public static void main(String[] args)
	{
		for (int i = 1; i <= LENGTH; i++)
		{
			for (int j = 1; j <= TOTAL_ROW; j++)
			{
				for (int k = 1; k <= TOTAL_COL; k++)
					System.out.print("* ");
				
				System.out.println();
			}
			
			System.out.println();
		}
	}
}
