public class PerfectNumber
{
	public static void main(String[] args)
	{
		for (int i = 1; i <= 1000; i++)
		{
			if (isPerfect(i))
			{
				System.out.printf("%d is a perfect number%n", i);
				
				for (int j = 1; j < i; j++)
				{
					if (i % j == 0)
					{
						System.out.printf("%d ", j);
					}
				}
				
				System.out.println();
			}
		}
	}
	
	public static boolean isPerfect(int number)
	{
		int result = 0;
		
		for (int i = 1; i < number; i++)
		{
			if (number % i == 0)
			{
				result += i;
			}
		}
		
		return result == number;
	}
}
