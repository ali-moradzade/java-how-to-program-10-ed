package QuickSortTest;

import java.security.SecureRandom;
import java.util.Arrays;

public class QuickSortTest
{
	public enum Direction{LEFT, RIGHT};
	
	public static void quickSort(int[] data)
	{
		quickSortHelper(data, 0, data.length - 1);
	}
	
	private static void quickSortHelper(int[] data, int start, int end)
	{
		if (end >= start)
		{
			int index = partition(data, start, end);
			
			quickSortHelper(data, start, index - 1);
			quickSortHelper(data, index + 1, end);
		}
	}
	
	private static int partition(int[] array, int start, int end)
	{
		Direction direction = Direction.LEFT;
		int index = start;
		int previousIndex = end + 1;
		boolean isAny = true;
		
		while (isAny)
		{
			isAny = false;
			
			if (direction == Direction.LEFT)
			{
				for (int i = previousIndex - 1; i > index; i--)
				{
					if (array[index] > array[i])
					{
						swap(array, index, i);
						printPartition(array, index, i);
						
						previousIndex = index;
						index = i;
						
						isAny = true;
						break;
					}
				}
			}
			else
			{
				for (int i = previousIndex + 1; i < index; i++)
				{
					if (array[index] < array[i])
					{
						swap(array, index, i);
						printPartition(array, index, i);
						
						previousIndex = index;
						index = i;
						
						isAny = true;
						break;
					}
				}
			}
		}
		
		return index;
	}
	
	private static void printPartition(int[] array, int index, int previousIndex)
	{
		int small = index < previousIndex ? index : previousIndex;
		int large = index < previousIndex ? previousIndex : index;
		
		for (int i = 0; i < small; i++)
		{
			System.out.printf("%d  ", array[i]);
		}
		
		System.out.printf("%d* ", array[small]);
		
		for (int i = small + 1; i < large; i++)
		{
			System.out.printf("%d  ", array[i]);
		}
		
		System.out.printf("%d* ", array[large]);
		
		for (int i = large + 1; i < array.length; i++)
		{
			System.out.printf("%d  ", array[i]);
		}
		
		System.out.println();
	}
	
	private static void swap(int[] data, int first, int second)
	{
		int temporary = data[first];
		data[first] = data[second];
		data[second] = temporary;
	}
	
	public static void main(String[] args)
	{
		SecureRandom generator = new SecureRandom();
		
		int[] data = new int[10];
		
		for (int i = 0; i < data.length; i++)
		{
			data[i] = 10 + generator.nextInt(90);
		}
		
		System.out.printf("Unsorted array: %n%s%n%n", Arrays.toString(data));
		quickSort(data);
		
		System.out.printf("Sorted array:%n%s%n%n", Arrays.toString(data));
	}
}






