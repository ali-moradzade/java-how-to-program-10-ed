package selectionsorttest;

import java.security.SecureRandom;
import java.util.Arrays;

public class SelectionSortTest
{
	public static void selectionSort(int[] data)
	{
		for (int i = 0; i < data.length - 1; i++)
		{
			int smallest = i;
			
			for (int index = i + 1; index < data.length; index++)
			{
				if (data[index] < data[smallest])
					smallest = index;
			}
			
			swap(data, i, smallest);
			printPass(data, i + 1, smallest);
		}
	}
	
	private static void swap(int[] data, int first, int second)
	{
		int temporary = data[first];
		data[first] = data[second];
		data[second] = temporary;
	}
	
	private static void printPass(int[] data, int pass, int index)
	{
		System.out.printf("after pass %2d: ", pass);
		
		for (int i = 0; i < index; i++)
		{
			System.out.printf("%d  ", data[i]);
		}
		
		System.out.printf("%d* ", data[index]);
		
		for (int i = index + 1; i < data.length; i++)
		{
			System.out.printf("%d  ", data[i]);
		}
		
		System.out.printf("%n               ");
		
		for (int j = 0; j < pass; j++)
		{
			System.out.print("--  ");
		}
		
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		SecureRandom generator = new SecureRandom();
		int[] data = new int[10];
		
		for (int i = 0; i < data.length; i++)
		{
			data[i] = 10 + generator.nextInt(90);
		}
		
		System.out.printf("Unsorted array:%n%s%n%n", Arrays.toString(data));
		selectionSort(data);
		
		System.out.printf("Sorted array:%n%s%n%n", Arrays.toString(data));
	}
}
