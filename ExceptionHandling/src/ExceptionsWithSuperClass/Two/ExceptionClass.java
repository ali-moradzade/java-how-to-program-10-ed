package ExceptionsWithSuperClass.Two;

import java.io.IOException;

public class ExceptionClass
{
	public static void main(String[] args)
	{
		try
		{
			throw new ExceptionA("ExceptionA");
		}
		catch (Exception e)
		{
			System.err.printf("cought exception of kind %s with class Exception.%n", 
				e.getClass().getName());
		}
		
		try
		{
			throw new ExceptionA("ExceptionB");
		}
		catch (Exception e)
		{
			System.err.printf("cought exception of kind %s with class Exception.%n", 
				e.getClass().getName());
		}
		
		try
		{
			throw new ExceptionA("ExceptionC");
		}
		catch (Exception e)
		{
			System.err.printf("cought exception of kind %s with class Exception.%n", 
				e.getClass().getName());
		}
		
		try
		{
			throw new NullPointerException("NullPointerException");
		}
		catch (Exception e)
		{
			System.err.printf("cought exception of kind %s with class Exception.%n", 
				e.getClass().getName());
		}
		
		try
		{
			throw new IOException("IOException");
		}
		catch (Exception e)
		{
			System.err.printf("cought exception of kind %s with class Exception.%n", 
				e.getClass().getName());
		}
	}
}
