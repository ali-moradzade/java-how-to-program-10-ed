package ReThrowingExceptions;

public class Test
{
	public static void main(String[] args)
	{
		try
		{
			someMethod();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	public static void someMethod() throws Exception
	{
		try
		{
			someMethod2();
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public static void someMethod2() throws Exception
	{
		throw new Exception("Exception thrown in method someMethod2");
	}
}
