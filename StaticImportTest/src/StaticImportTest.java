import static java.lang.Math.*;

public class StaticImportTest
{
	public static void main(String[] args)
	{
		System.out.printf("sqrt(900.0) = %.2f%n", sqrt(900.0));
		System.out.printf("ceil(-9.8) = %.2f%n", ceil(-9.8));
		System.out.printf("E = %f%n", E);
		System.out.printf("PI = %f%n", PI);
	}
}
