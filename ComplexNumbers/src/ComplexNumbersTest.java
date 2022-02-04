public class ComplexNumbersTest
{
	public static void main(String[] args)
	{
		ComplexNumbers complex1 = new ComplexNumbers(1, 1);
		ComplexNumbers complex2 = new ComplexNumbers(11, 11);
	
		System.out.printf("%s + %s: %s%n",
			complex1, complex2, complex1.add(complex2));
		System.out.printf("%s - %s: %s%n", 
			complex1, complex2, complex1.subtract(complex2));
	}
}
