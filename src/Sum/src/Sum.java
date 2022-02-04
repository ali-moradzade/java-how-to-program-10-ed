public class Sum
{
	public static void main(String[] args)
	{
		int sum = 0;
		int number = 1;
		
		while (number <= 10)
		{
			sum += number;
			number++;
		}
		
		System.out.printf("Sum is %d%n", sum);
	}
}
