package come.deitel.datastructures;

public class StackInheritance<T> extends List<T>
{
	public StackInheritance()
	{
		super("stack");
	}
	
	public void push(T object)
	{
		insertAtFront(object);
	}
	
	public T pop() throws EmptyListException
	{
		return removeFromFront();
	}
}


