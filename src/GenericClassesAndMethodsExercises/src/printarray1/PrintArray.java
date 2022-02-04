package printarray1;

public class PrintArray
{
	public static void main(String[] args)
	{
		Integer[] integerArray = {1, 2, 3, 4, 5, 6};
		Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
		Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};
		String[] stringArray = 
			{"one", "two", "three", "four", "five", "six", "seven", "eight"};
		
		System.out.println("Array integerArray contains:");
		printArray(integerArray);
		
		System.out.printf("%nArray doubleArray contains:%n");
		printArray(doubleArray);
		
		System.out.printf("%nArray characterArray contains:%n");
		printArray(characterArray);
		
		System.out.printf("%nArray stringArray contains:%n");
		printArray(stringArray);
	}
	
	public static <T> void printArray(T[] inputArray)
	{
		for (T element : inputArray)
		{
			System.out.printf("%s ", element);
		}
		
		System.out.println();
	}
	
	public static void printArray(String[] inputArray)
	{
		for (int i = 0; i < inputArray.length; i++)
		{
			System.out.printf("%-10s%s", inputArray[i], (i + 1) % 4 == 0 ? "\n" : "");
		}
		
		System.out.println();
	}
}
	


