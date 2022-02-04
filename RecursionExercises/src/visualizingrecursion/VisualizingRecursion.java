package visualizingrecursion;

public class VisualizingRecursion
{
	public static long factorial(long number)
	{
		if (number <= 1)
		{
			System.out.println("Returned 1 to method call");
			return 1;
		}
		else
		{
			System.out.printf("Step into next method call (number = %d)%n", 
				number);
			return number * factorial(number - 1);
		}
	}
	
	public static void main(String[] args)
	{
		for (int counter = 0; counter <= 10; counter++)
		{
			System.out.printf("%d! = %d%n%n", counter, factorial(counter));
		}
	}
}
