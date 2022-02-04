package sum;

public class Sum
{
	public static void main(String[] args)
	{
		int n = 10;
		System.out.printf("Sum of numbers from 0 to %d is: %d%n", n, sum(n));
	}
	
	public static int sum(int number)
	{
		if (number == 0)
			return 0;
		else
			return number + sum(number - 1);
	}
}
