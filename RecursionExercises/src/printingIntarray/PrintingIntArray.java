package printingIntarray;

public class PrintingIntArray
{
	public static void main(String[] args)
	{
		int[][] two = {{1, 2, 3},
							{4, 5},
							{6, 7, 8, 9}};
		
		int[] one = {1, 2, 3, 4, 5};
		printArray(one, 0);
	}
	
	public static void printArray(int[] array, int index)
	{
		if (index < array.length)
		{
			System.out.print(array[index] + " ");
			printArray(array, index + 1);
		}
		else
			System.out.println();
	}
}
