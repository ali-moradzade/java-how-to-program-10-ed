package RecursiveBinarySearch;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class RecursiveBinarySearch
{
	public static int binarySearch(int[] data, int key)
	{
		return search(data, 0, data.length - 1, key);
	}
	
	public static int search(int[] data, int start, int end, int key)
	{
		if (start <= end)
		{
			int middle = (start + end + 1) / 2;

			if (key == data[middle])
				return middle;
			else if (key > data[middle])
				return search(data, middle + 1, end, key);
			else
				return search(data, start, middle - 1, key);
		}
		
		return -1;
	}
	
	private static String remainingElements(int[] data, int low, int high)
	{
		StringBuilder temporary = new StringBuilder();
		
		for (int i = 0; i < low; i++)
		{
			temporary.append("   ");
		}
		
		for (int i = low; i <= high; i++)
		{
			temporary.append(data[i] + " ");
		}
		
		return String.format("%s%n", temporary);
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		SecureRandom generator = new SecureRandom();
		
		int[] data = new int[15];
		
		for (int i = 0; i < data.length; i++)
		{
			data[i] = 10 + i;
		}
		
		Arrays.sort(data);
		System.out.printf("%s%n%n", Arrays.toString(data));
		
		System.out.print("Please enter an integer value (-1 to quit): ");
		int searchInt = input.nextInt();
		
		while (searchInt != -1)
		{
			int location = binarySearch(data, searchInt);
			
			if (location == -1)
				System.out.printf("%d was not found%n%n", searchInt);
			else
				System.out.printf("%d was found in position %d%n%n",
					searchInt, location);
			
			System.out.print("Please enter an integer value (-1 to quit): ");
			searchInt = input.nextInt();
		}
	}
}


