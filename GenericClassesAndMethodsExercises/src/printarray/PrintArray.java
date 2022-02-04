package printarray;

public class PrintArray
{
	public static void main(String[] args)
	{
		Integer[] integerArray = {1, 2, 3, 4, 5, 6};
		Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
		Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};
		
		System.out.println("Array integerArray contains:");
		printArray(integerArray);
		System.out.println("Array integerArray from index 2 to 4 contains:");
		printArray(integerArray, 2, 4);
		
		System.out.printf("%nArray doubleArray contains:%n");
		printArray(doubleArray);
		System.out.println("Array doubleArray from index 2 to 4 contains:");
		printArray(doubleArray, 2, 4);
		
		System.out.printf("%nArray characterArray contains:%n");
		printArray(characterArray);
		System.out.println("Array characterArray from index 2 to 4 contains:");
		printArray(characterArray, 2, 4);
		
		try
		{
			System.out.printf("%nArray doubleArray from index 2 to 7 contains:%n");
			printArray(doubleArray, 2, 7);
		}
		catch (InvalidSubscriptException e)
		{
			e.printStackTrace(System.out);
		}
	}
	
	public static <T> int printArray(T[] inputArray)
	{
		for (T element : inputArray)
		{
			System.out.printf("%s ", element);
		}
		
		System.out.println();
		
		return inputArray.length;
	}
	
	public static <T> int printArray(T[] inputArray, int lowSubscript,
		int highSubscript)
	{
		if (lowSubscript < 0 || lowSubscript > highSubscript)
			throw new InvalidSubscriptException(
				"low subscript must be >= 0 and <= high subscript.");
		
		if (highSubscript >= inputArray.length)
			throw new InvalidSubscriptException(
				"high subscript must >= low subscript and < length.");
		
		for (int i = lowSubscript; i <= highSubscript; i++)
		{
			System.out.printf("%s ", inputArray[i]);
		}
		
		System.out.println();
		
		return highSubscript - lowSubscript + 1;
	}
}







