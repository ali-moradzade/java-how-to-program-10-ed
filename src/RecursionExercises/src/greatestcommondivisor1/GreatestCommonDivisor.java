package greatestcommondivisor1;

public class GreatestCommonDivisor
{
	public static int gcd(int x, int y)
	{
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}
	
	public static void main(String[] args)
	{
		int x = 24;
		int y = 18;
		
		System.out.printf("Greatest common divisor between %d and %d is: %d%n",
			x, y, gcd(x, y));
	}
}
