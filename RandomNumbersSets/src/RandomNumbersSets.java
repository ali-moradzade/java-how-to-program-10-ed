import java.util.Random;

public class RandomNumbersSets
{
	public static void main(String[] args)
	{
		Random randomNumbers = new Random();
		
		for (int i = 0; i <= 10; i++)
		{
			int number = 2 + 2 * randomNumbers.nextInt(5);
			System.out.print(number + " ");
		}
		
		System.out.println();
	}
}
