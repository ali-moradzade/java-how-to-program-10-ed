package convertingintarraytostring;

public class Converti
{
	public static void main(String[] args)
	{
		final int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		System.out.printf("Int array in string format: %s%n", convert(array, 0));
		System.out.printf("Int array in string format in reversed order: %s%n",
			convertToReverse(array, 0));
	}

	public static String convert(int[] array, int x)
	{
		if (x < array.length)
			return String.format("%d %s", array[x], convert(array, x + 1));
		else
			return "";
	}
	
	public static String convertToReverse(int[] array, int x)
	{
		if (x < array.length)
			return String.format("%s%d ", convertToReverse(array, x + 1), array[x]);
		else
			return "";
	}
}
