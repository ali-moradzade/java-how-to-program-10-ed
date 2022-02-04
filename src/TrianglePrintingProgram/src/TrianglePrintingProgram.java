public class TrianglePrintingProgram
{
	private static final int LENGTH = 35;
	
	public static void main(String[] args)
	{
		print1();
		print2();
		print3();
		print4();
	}
	
	public static void print1()
	{
		for (int row = 1; row <= LENGTH; row++)
		{
			for (int star = 1; star <= row; star++)
				System.out.print("*");
			
			System.out.println();
		}
		
		System.out.println();
	}
	
	public static void print2()
	{
		for (int row = 1; row <= LENGTH; row++)
		{
			for (int star = 1; star <= LENGTH + 1 - row; star++)
				System.out.print("*");
			
			System.out.println();
		}
		
		System.out.println();
	}
	
	public static void print3()
	{
		for (int row = 1; row <= LENGTH; row++)
		{
			for (int space = 1; space <= row - 1; space++)
				System.out.print(" ");
			
			for (int star = 1; star <= LENGTH + 1 - row; star++)
				System.out.print("*");
			
			System.out.println();
		}
		
		System.out.println();
	}
	
	public static void print4()
	{
		for (int row = 1; row <= LENGTH; row++)
		{
			for (int space = 1; space <= LENGTH - row; space++)
				System.out.print(" ");
			
			for (int star = 1; star <= row; star++)
				System.out.print("*");
			
			System.out.println();
		}
	}
}
