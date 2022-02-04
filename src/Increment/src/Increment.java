public class Increment
{
	public static void main(String[] args)
	{
		int c = 5;
		System.out.printf("c before postincrement: %d%n", c);
		System.out.printf("    postincrementing c: %d%n", c++);
		System.out.printf(" c after postincrement: %d%n%n", c);
		
		c = 5;
		System.out.printf("c before preincrementing: %d%n", c);
		System.out.printf("       preincrementing c: %d%n", ++c);
		System.out.printf(" c after preincrementing: %d%n%n", c);
	}
}
