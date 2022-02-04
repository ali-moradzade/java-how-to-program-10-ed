package list;

public class Stack<T>
{
	private final List<T> stackList;
	
	public Stack()
	{
		this("stack");
	}
	
	public Stack(String name)
	{
		stackList = new List<>(name);
	}
	
	public void push(T insertItem)
	{
		stackList.insertAtFront(insertItem);
	}
	
	public T pop() throws EmptyListException
	{
		return stackList.removeFromFront();
	}
	
	public boolean isEmpty()
	{
		return stackList.isEmpty();
	}
	
	public void print()
	{
		stackList.print();
	}
}


