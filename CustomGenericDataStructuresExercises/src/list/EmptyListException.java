package list;

public class EmptyListException extends RuntimeException
{
	public EmptyListException()
	{
		this("list is empty");
	}
	
	public EmptyListException(String name)
	{
		super(name + " is empty");
	}
}


