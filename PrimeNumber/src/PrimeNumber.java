public class PrimeNumber
{
	public static void main(String[] args)
	{
		System.out.println("Finding primes with isPrime1:");
		
		for (int count = 1; count < 100; count++)
		{
			if (isPrime1(count))
				System.out.print(count + " ");
		}
		
		System.out.printf("%n%nFinding primes with isPrime1:%n");
		
		for (int count = 1; count < 100; count++)
		{
			if (isPrime1(count))
				System.out.print(count + " ");
		}
		
		System.out.printf("%n%nFinding primes with isPrime1:%n");
		
		for (int count = 1; count < 100; count++)
		{
			if (isPrime1(count))
				System.out.print(count + " ");
		}
		
		System.out.println();
	}
	
	public static boolean isPrime1(int number)
	{
		if (number == 1)
			return false;
		
		for (int count = 2; count < number; count++)
		{
			if (number % count == 0)
				return false;
		}
		
		return true;
	}
	
	public static boolean isPrime2(int number)
	{
		if (number == 1)
			return false;
		
		for (int count = 2; count < number / 2; count++)
			if (number % count == 0)
				return false;
		
		return true;
	}
	
	public static boolean isPrime3(int number)
	{
		if (number == 1)
			return false;
		
		for (int count = 2; count < (int) Math.sqrt(number) + 1; count++)
			if (number % count == 0)
				return false;
		
		return true;
	}
}
