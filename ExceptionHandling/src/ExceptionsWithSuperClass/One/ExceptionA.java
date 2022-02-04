package ExceptionsWithSuperClass.One;

public class ExceptionA extends Exception
{
	private final String message;
	
	public ExceptionA(String message)
	{
		this.message = message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}

	@Override
	public String toString()
	{
		return getMessage();
	}
}
