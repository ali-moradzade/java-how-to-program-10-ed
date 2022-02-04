package StringBuilderConstructors;

public class StringBuilderConstructors
{
	public static void main(String[] args)
	{
		StringBuilder buffer1 = new StringBuilder();
		StringBuilder buffer2 = new StringBuilder(10);
		StringBuilder buffer3 = new StringBuilder("hello");
		
		System.out.printf("buffer1 = \"%s\"\t\t buffer1 capacity = %d%n", 
			buffer1, buffer1.capacity());
		System.out.printf("buffer2 = \"%s\"\t\t buffer2 capacity = %d%n",
			buffer2, buffer2.capacity());
		System.out.printf("buffer3 = \"%s\"\t buffer3 capacity = %d%n", 
			buffer3, buffer3.capacity());
	}
}
