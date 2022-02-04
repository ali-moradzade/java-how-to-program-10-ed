package product;

public class Product
{
	public static void main(String[] args)
	{
		int a = 5;
		int b = 5;
		
		System.out.printf("%d * %d = %d%n", a, b, product(a, b));
	}
	
	public static long product(long a, long b)
	{
		if (b <= 1)
			return a;
		else
			return a + product(a, b - 1);
	}
}
