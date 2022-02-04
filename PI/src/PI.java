public class PI
{
	private static final int LENGTH_OF_SECTIONS = 200;
	
	public static void main(String[] args)
	{
		System.out.printf("PI with %d sections is %.15f%n", LENGTH_OF_SECTIONS, pi());
	}
	
	public static double pi()
	{
		double result = 0;
		
		for (int i = 0; i < LENGTH_OF_SECTIONS; i++)
		{
			result += (4.0 / (2 * i + 1)) * Math.pow(-1, i);
		}
		
		return result;
	}
}
