package recursivelinearsearch;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class RecursiveLinearSearch
{
	public static int linearSearch(int[] data, int searchKey)
	{
		return search(data, 0, searchKey);
	}
	
	private static int search(int[] data, int startingIndex, int searchKey)
	{
		if (startingIndex < data.length)
		{
			if (data[startingIndex] == searchKey)
				return startingIndex;
			else
				return search(data, startingIndex + 1, searchKey);
		}
		
		return -1;
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		SecureRandom generator = new SecureRandom();
		
		int[] data = new int[5];
		
		for (int i = 0; i < data.length; i++)
		{
			data[i] = 10 + generator.nextInt(90);
		}
		
		System.out.printf("%s%n%n", Arrays.toString(data));
		
		System.out.print("Please enter an integer value (-1 to quit): ");
		int searchKey = input.nextInt();
		
		while (searchKey != -1)
		{
			int position = linearSearch(data, searchKey);
			
			if (position == -1)
				System.out.printf("%d was not found%n%n", searchKey);
			else
				System.out.printf("%d was found in position %d%n%n",
					searchKey, position);
			System.out.print("Please enter an integer value (-1 to quit): ");
			searchKey = input.nextInt();
		}
	}
}







