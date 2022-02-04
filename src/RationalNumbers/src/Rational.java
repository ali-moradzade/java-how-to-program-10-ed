public class Rational
{
	private int numerator;
	private int denominator;
	
	public Rational()
	{
		this(1, 1);
	}
	
	public Rational(int numerator, int denominator)
	{
		if (denominator == 0)
			throw new IllegalArgumentException("denominator must be opposite to zero");
		
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public int getNumerator()
	{
		return numerator;
	}
	
	public int getDenominator()
	{
		return denominator;
	}
	
	public Rational convertToReducedForm()
	{
		if (getNumerator() == 0)
			return this;
		
		int gcd = gcd(getNumerator(), getDenominator());
		
		numerator /= gcd;
		denominator /= gcd;
		
		return new Rational(numerator, denominator);
	}
	
	private static int gcd(int number1, int number2)
	{
		if (number1 == 0 || number2 == 0)
			return 0;
		
		if (number2 > number1)
		{
			int temp = number1;
			number1 = number2;
			number2 = temp;
		}
		
		while (number2 != 0)
		{
			int temp = number1;
			number1 = number2;
			number2 = temp % number2;
		}
		
		return number1;
	}
	
	public static Rational add(Rational number1, Rational number2)
	{
		return new Rational(
			number1.getNumerator() * number2.getDenominator() +
			number2.getNumerator() * number1.getDenominator(), 
			number1.getDenominator() * number2.getDenominator());
	}
	
	public static Rational subtract(Rational number1, Rational number2)
	{
		return new Rational(
			number1.getNumerator() * number2.getDenominator() -
			number2.getNumerator() * number1.getDenominator(), 
			number1.getDenominator() * number2.getDenominator());
	}
	
	public static Rational multiply(Rational number1, Rational number2)
	{
		return new Rational(
			number1.getNumerator() * number2.getNumerator(),
			number1.getDenominator() * number2.getDenominator());
	}
	
	public static Rational divide(Rational number1, Rational number2)
	{
		return new Rational(
			number1.getNumerator() * number2.getDenominator(),
			number1.getDenominator() * number2.getNumerator());
	}
	
	public String rationalForm()
	{
		return toString();
	}
	
	public String floatingPointForm()
	{
		return Double.toString((double) getNumerator() / getDenominator());
	}
	
	@Override
	public String toString()
	{
		return String.format("%d/%d", getNumerator(), getDenominator());
	}
}
