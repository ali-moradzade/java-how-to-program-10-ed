package ArrayManipulations;

import java.util.Arrays;

public class ArrayManipulations
{
	public static void main(String[] args)
	{
		double[] doubleArray = {8.4, 9.3, 0.2, 7.9, 3.4};
		
		System.out.println("Original doubleArray:");
		
		for (double value : doubleArray)
		{
			System.out.printf("%.1f ", value);
		}
		
		System.out.println();
		
		System.out.println("\nSorted doubleArray:");
		Arrays.sort(doubleArray);
		
		for (double value : doubleArray)
		{
			System.out.printf("%.1f ", value);
		}
		
		System.out.println();
		
		int[] filledIntArray = new int[10];
		Arrays.fill(filledIntArray, 7);
		displayArray(filledIntArray, "filledIntArray");
		
		int[] intArray = {1, 2, 3, 4, 5, 6};
		int[] intArrayCopy = new int[intArray.length];
		
		System.arraycopy(intArray, 0, intArrayCopy, 0, intArray.length);
		displayArray(intArray, "intArray");
		displayArray(intArrayCopy, "intArrayCopy");
		
		boolean b = Arrays.equals(intArray, intArrayCopy);
		System.out.printf("%n%nintArray %s intArrayCopy%n",
			(b ? "==" : "!="));
		
		b = Arrays.equals(intArray, filledIntArray);
		System.out.printf("intArray %s filledIntArray%n",
			(b ? "==" : "!="));
		
		int location = Arrays.binarySearch(intArray, 5);
		
		if (location >= 0)
			System.out.printf("Found 5 at element %d in intArray%n", location);
		else
			System.out.println("5 not found in intArray");
		
		location = Arrays.binarySearch(intArray, 8763);
		
		if (location >= 0)
			System.out.printf("Found 8753 at element %d in intArray%n", location);
		else
			System.out.printf("8763 not found in intArray(location = %d)%n", 
				location);
	}
	
	public static void displayArray(int[] array, String description)
	{
		System.out.printf("%n%s: ", description);
		
		for (int value : array)
		{
			System.out.printf("%d ", value);
		}
	}
}
