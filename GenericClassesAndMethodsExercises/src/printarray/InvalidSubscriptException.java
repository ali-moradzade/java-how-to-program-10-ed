package printarray;

public class InvalidSubscriptException extends RuntimeException
{
	public InvalidSubscriptException()
	{
		this("low subscript and/or high subscript is invalid");
	}
	
	public InvalidSubscriptException(String message)
	{
		super(message);
	}
}


