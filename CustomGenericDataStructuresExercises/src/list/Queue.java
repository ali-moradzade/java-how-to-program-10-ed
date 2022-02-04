package list;

public class Queue<T>
{
	private final List<T> queueList;
	
	public Queue()
	{
		this("queue");
	}
	
	public Queue(String name)
	{
		queueList = new List<>(name);
	}
	
	public void enqueue(T insertItem)
	{
		queueList.insertAtBack(insertItem);
	}
	
	public T dequeue() throws EmptyListException
	{
		return queueList.removeFromFront();
	}
	
	public boolean isEmpty()
	{
		return queueList.isEmpty();
	}
	
	public void print()
	{
		queueList.print();
	}
}


