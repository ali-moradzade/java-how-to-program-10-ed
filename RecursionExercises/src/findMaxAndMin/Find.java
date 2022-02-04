package findMaxAndMin;

import java.util.Arrays;

public class Find
{
	public static int findMinimum(int A[], int n)
	{
		// if size = 0 means whole array 
		// has been traversed 
		if (n == 1)
			return A[0];

		return Math.min(A[n - 1], findMinimum(A, n - 1));
	}
	
	public static int findMaximum(int A[], int n)
	{
		// if size = 0 means whole array 
		// has been traversed 
		if (n == 1)
			return A[0];

		return Math.max(A[n - 1], findMaximum(A, n - 1));
	}
	
	public static void main(String args[])
	{
		int[] array = {1, -1, 2, -2, 3, -3, 0};
		
		System.out.printf("Original array: %s%n", Arrays.toString(array));
		
		System.out.printf("Max: %d%nMin: %d%n",
			findMaximum(array, array.length),  findMinimum(array, array.length));
	}
}
