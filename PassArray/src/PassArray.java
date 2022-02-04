public class PassArray
{
	public static void main(String[] args)
	{
		int[] array = {1, 2, 3, 4, 5};
		
		System.out.printf("%s%n%s%n",
			"Effects of passing reference to entire array:",
			"The values of the original array are:");
		showArray(array);
		
		modifyArray(array);
		System.out.printf("%n%nThe values of the modified array are:%n");
		showArray(array);
		
		System.out.printf("%n%n%s%n%s%d%n",
			"Effects of passing array element value:",
			"array[3] before modifyElement: ", array[3]);
		
		modifyElement(array[3]);
		System.out.printf("array[3] after modifyElement: %d%n", array[3]);
	}
	
	public static void modifyArray(int[] array)
	{
		for (int counter = 0; counter < array.length; counter++)
		{
			array[counter] *= 2;
		}
	}
	
	public static void modifyElement(int element)
	{
		element *= 2;
		System.out.printf("Value of element in modifyElement is %d%n", element);
	}
	
	public static void showArray(int[] array)
	{
		for (int number : array)
		{
			System.out.printf("  %d", number);
		}
	}
}
