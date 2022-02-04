package sumarray;

import java.util.Arrays;

public class SumArray
{
	public static void main(String[] args)
	{
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.printf("original array is %s%n%n", Arrays.toString(array));
		
		for (int i = 1; i <= 10; i++)
		{
			System.out.printf("Sum of elements up to element %d is: %d%n",
				i - 1, sum(array, i));
		}
	}

	public static int sum(int[] array, int size)
	{
		if (size == 1)
			return array[0];
		else
			return array[size - 1] + sum(array, size - 1);
	}
}
