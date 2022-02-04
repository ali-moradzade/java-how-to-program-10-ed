public class RationalTest
{
	public static void main(String[] args)
	{
		Rational number1 = new Rational(2, 4);
		Rational number2 = new Rational(3, 5);
		
		System.out.printf("%s: %s%n%s: %s%n%s: %s%n%n",
			"number1 as rational form", number1.rationalForm(),
			"number1 as floating-point form:", number1.floatingPointForm(),
			"number1 when reduced to the most simple rational form", 
			number1.convertToReducedForm());
		
		System.out.printf(
			"%s add %s: %s%n%s subtract %s: %s%n%s multiply %s: %s%n%s divide %s: %s%n", 
			number1, number2, Rational.add(number1, number2),
			number1, number2, Rational.subtract(number1, number2),
			number1, number2, Rational.multiply(number1, number2),
			number1, number2, Rational.divide(number1, number2));
	}
}
