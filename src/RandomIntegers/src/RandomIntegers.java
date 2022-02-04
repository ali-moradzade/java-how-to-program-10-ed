import java.security.SecureRandom;

public class RandomIntegers
{
	public static void main(String[] args)
	{
		SecureRandom randomNumbers = new SecureRandom();
		
		for (int counter = 1; counter <= 20; counter++)
		{
			int face = 1 + randomNumbers.nextInt(6);
			
			System.out.printf("%d  %s", face, (counter % 5 == 0 ? "\n" : ""));
		}
	}
}
