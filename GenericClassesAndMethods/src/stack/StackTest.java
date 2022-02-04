package stack;

public class StackTest
{
	public static void main(String[] args)
	{
		double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5};
		int[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		Stack<Double> doubleStack = new Stack<>(5);
		Stack<Integer> integerStack = new Stack<>();
		
		testPushDouble(doubleStack, doubleElements);
		testPopDouble(doubleStack);
		
		testPushInteger(integerStack, integerElements);
		testPopInteger(integerStack);
	}
	
	private static void testPushDouble(Stack<Double> stack, double[] values)
	{
		System.out.printf("%nPushing elements onto doubleStack%n");
		
		for (double value : values)
		{
			System.out.printf("%.1f ", value);
			stack.push(value);
		}
	}
	
	private static void testPopDouble(Stack<Double> stack)
	{
		try
		{
			System.out.printf("%nPopping elements from doubleStack%n");
			double popValue;
			
			while (true)
			{
				popValue = stack.pop();
				System.out.printf("%.1f ", popValue);
			}
		}
		catch (EmptyStackException emptyStackException)
		{
			System.out.println();
			emptyStackException.printStackTrace(System.out);
		}
	}
	
	private static void testPushInteger(Stack<Integer> stack, int[] values)
	{
		System.out.printf("%nPushing elements onto integerStack%n");
		
		for (int value : values)
		{
			System.out.printf("%d ", value);
			stack.push(value);
		}
	}
	
	private static void testPopInteger(Stack<Integer> stack)
	{
		try
		{
			System.out.printf("%nPopping elements from integerStack%n");
			int popValue;
			
			while (true)
			{
				popValue = stack.pop();
				System.out.printf("%d ", popValue);
			}
		}
		catch (EmptyStackException emptyStackException)
		{
			System.out.println();
			emptyStackException.printStackTrace(System.out);
		}
	}
}



