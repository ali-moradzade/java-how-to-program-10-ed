package bubblesorttest1;

import java.security.SecureRandom;
import java.util.Arrays;

public class BubbleSortTest
{
	public static void bubbleSort(int[] data)
	{
		boolean alreadySorted = false;
		
		for (int pass = 1; pass <= data.length - 1; pass++)
		{
			alreadySorted = true;
			
			for (int first = 0; first < data.length - pass ; first++)
			{
				if (data[first] > data[first + 1])
				{
					swap(data, first, first + 1);
					alreadySorted = false;
					
					swapDisplay(data, first, first + 1);
				}
			}
			
			if (alreadySorted == true)
				return;
			
			printPass(data, pass);
		}
	}
	
	private static void swap(int[] data, int first, int second)
	{
		int temporary = data[first];
		data[first] = data[second];
		data[second] = temporary;
	}
	
	private static void swapDisplay(int[] data, int first, int second)
	{
		System.out.print("               ");
		
		for (int i = 0; i < first; i++)
		{
			System.out.printf("%d  ", data[i]);
		}
		
		System.out.printf("%d* ", data[first]);
		
		for (int i = first + 1; i < second; i++)
		{
			System.out.printf("%d  ", data[i]);
		}
		
		System.out.printf("%d* ", data[second]);
		
		for (int i = second + 1; i < data.length; i++)
		{
			System.out.printf("%d  ", data[i]);
		}
		
		System.out.println();
	}
	
	private static void printPass(int[] data, int pass)
	{
		System.out.printf("%nafter pass %2d: ", pass);
		
		for (int i = 0; i < data.length; i++)
		{
			System.out.printf("%d  ", data[i]);
		}
		
		System.out.printf("%n               ");
		
		for (int j = 0; j < data.length - pass; j++)
		{
			System.out.print("    ");
		}
		
		for (int i = data.length - pass; i < data.length; i++)
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
		bubbleSort(data);
		
		System.out.printf("Sorted array:%n%s%n%n", Arrays.toString(data));
	}
}







