package Product1;

public class Product
{
	public static void main(String[] args)
	{
		int product = 1;
		
		for (int number = 1; number <= 15; number += 2)
		{
			product *= number;
		}
		
		System.out.printf("Product is %d%n", product);
	}
}
