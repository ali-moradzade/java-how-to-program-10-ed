package ExceptionsWithSuperClass.Three;

import ExceptionsWithSuperClass.Two.ExceptionA;

public class Order
{
	public static void main(String[] args)
	{
		// this order is correct
		try
		{
			throw new ExceptionA("ExceptionA");
		}
		catch (ExceptionA exceptionA)
		{
			// do things
		}
		catch (Exception exception)
		{
			// do things
		}
		
//		// this order is wrong
//		try
//		{
//			throw new ExceptionA("ExceptionA");
//		}
//		catch (Exception exception)
//		{
//			// do things
//		}
//		catch (ExceptionA exceptionA)
//		{
//			// do things
//		}
	}
}
