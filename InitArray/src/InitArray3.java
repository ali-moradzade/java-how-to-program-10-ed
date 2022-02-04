public class InitArray3
{
	public static void main(String[] args)
	{
		int[][] array1 = {{1, 2, 3}, {4, 5, 6}};
		int[][] array2 = {{1, 2}, {3}, {4, 5, 6}};
		
		outputArray("Values in array1 by row are", array1);
		
		outputArray("\nValues in array2 by row are", array2);
	}
	
	public static void outputArray(String description, int[][] array)
	{
		System.out.println(description);
	
		for (int row = 0; row < array.length; row++)
		{
			for (int column = 0; column < array[row].length; column++)
			{
				System.out.printf("%d ", array[row][column]);
			}
			
			System.out.println();
		}
	}
}
