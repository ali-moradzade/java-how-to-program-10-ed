package CatchingExceptionsUsingOuterScopes;

import java.io.IOException;

public class Test
{
	public static void main(String[] args)
	{
		try
		{
			method1();
		}
		catch (IOException e)
		{
			System.err.println("IOException cought in method main.");
		}
	}
	
	public static void method1() throws IOException 
	{
		try
		{
			method2();
		}
		catch (NullPointerException e)
		{
			System.err.printf("%s%n%s%n", 
				"NullPointerException cought in method1 but",
				"IOException remained for catching in main.");
			
			method3();
		}
	}
	
	public static void method2() throws NullPointerException
	{
		throw new NullPointerException("NullPointerException thrown in method2");
	}
	
	public static void method3() throws IOException
	{
		throw new IOException("IOException thrown in method3");
	}
}
