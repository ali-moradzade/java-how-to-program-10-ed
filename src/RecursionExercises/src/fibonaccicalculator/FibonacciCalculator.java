package fibonaccicalculator;

import java.math.BigInteger;

public class FibonacciCalculator
{
	public static BigInteger fibonacci(BigInteger number)
	{
		if (number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE))
			return number;
		else
			return fibonacci(number.subtract(BigInteger.ONE))
				.add(fibonacci(number.subtract(BigInteger.TWO)));
	}

	public static void main(String[] args)
	{
		for (int counter = 0; counter <= 35; counter++)
		{
			long start = System.currentTimeMillis();
			
			System.out.printf("Fibonacci of %2d is: %10d; ", counter, 
				fibonacci(BigInteger.valueOf(counter)));
			
			long end = System.currentTimeMillis();
			System.out.printf("%d%n", end - start);
		}
	}
}
