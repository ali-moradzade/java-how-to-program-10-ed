package ExceptionsWithSuperClass.One;

public class ExceptionTest
{
	public static void main(String[] args)
	{
		try
		{
			throw new ExceptionC("ExceptionC");
		}
		catch (ExceptionB e)
		{
			System.err.printf("Exception: %s, cought with Exception type ExceptionB%n",
				e.getMessage());
		}
		
		try
		{
			throw new ExceptionC("ExceptionC");
		}
		catch (ExceptionA e)
		{
			System.err.printf("Exception: %s, cought with Exception type ExceptionA%n",
				e.getMessage());
		}
		
		try
		{
			throw new ExceptionB("ExceptionB");
		}
		catch (ExceptionB e)
		{
			System.err.printf("Exception: %s, cought with Exception type ExceptionA%n",
				e.getMessage());
		}
	}
}
