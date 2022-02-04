package factorialcalculator1;

import java.math.BigInteger;

public class FactorialCalculator
{
	public static BigInteger factorial(BigInteger number)
	{
		if (number.compareTo(BigInteger.ONE) <= 0)
			return BigInteger.ONE;
		else
			return number.multiply(factorial(number.subtract(BigInteger.ONE)));
	}

	public static void main(String[] args)
	{
		for (int counter = 0; counter <= 50; counter++)
		{
			System.out.printf("%2d! = %d%n", 
				counter, factorial(BigInteger.valueOf(counter)));
		}
	}
}
