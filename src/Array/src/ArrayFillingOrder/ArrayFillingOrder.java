package ArrayFillingOrder;

public class ArrayFillingOrder
{
	public static void main(String[] args)
	{
		int[][] sales = new int[3][5];
		int count = 1;
		
		for (int row = 0; row < sales.length; row++)
		{
			for (int col = 0; col < sales[row].length; col++)
			{
				sales[row][col] = count;
				count++;
			}
		}
		
		display(sales);
	}
	
	public static void display(int[][] array)
	{
		for (int row = 0; row < array.length; row++)
		{
			for (int col = 0; col < array[row].length; col++)
			{
				System.out.printf("%2d ", array[row][col]);
			}
			
			System.out.println();
		}
	}
}
