package ListConcatenate;

class ListNode<T>
{
	T data;
	ListNode<T> nextNode;
	
	public ListNode(T data)
	{
		this(data, null);
	}
	
	public ListNode(T data, ListNode<T> nextNode)
	{
		this.data = data;
		this.nextNode = nextNode;
	}
}
	
public class List<T>
{
	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	private String name;
	
	public List()
	{
		this("list");
	}
	
	public List(String name)
	{
		this.name = name;
		firstNode = lastNode = null;
	}
	
	public void insertAtFront(T insertItem)
	{
		if (isEmpty())
			firstNode = lastNode = new ListNode<>(insertItem);
		else
			firstNode = new ListNode<>(insertItem, firstNode);
	}
	
	public void insertAtBack(T insertItem)
	{
		if (isEmpty())
			firstNode = lastNode = new ListNode<>(insertItem);
		else
			lastNode = lastNode.nextNode = new ListNode<>(insertItem);
	}
	
	public T removeFromFront() throws EmptyListException
	{
		if (isEmpty())
			throw new EmptyListException();
		
		T removedItem = firstNode.data;
		
		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else
			firstNode = firstNode.nextNode;
		
		return removedItem;
	}
	
	public T removeFromBack() throws EmptyListException
	{
		if (isEmpty())
			throw new EmptyListException();
		
		T removedItem = lastNode.data;
		
		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else
		{
			ListNode<T> currentNode = firstNode;
			
			while (currentNode.nextNode != lastNode)
			{
				currentNode = currentNode.nextNode;
			}
			
			lastNode = currentNode;
			currentNode.nextNode = null;
		}
		
		return removedItem;
	}
	
	public boolean isEmpty()
	{
		return firstNode == null;
	}
	
	public void print()
	{
		if (isEmpty())
		{
			System.out.printf("Empty %s%n", name);
			return;
		}
		
		System.out.printf("The %s is: ", name);
		ListNode<T> current = firstNode;
		
		while (current != null)
		{
			System.out.printf("%s ", current.data);
			current = current.nextNode;
		}
		
		System.out.println();
	}
	
	void setFirstNode(ListNode<T> firstNode)
	{
		this.firstNode = firstNode;
	}
	
	ListNode<T> getFirstNode()
	{
		return firstNode;
	}
	
	void setLastNode(ListNode<T> lastNode)
	{
		this.lastNode = lastNode;
	}
	
	ListNode<T> getLastNode()
	{
		return lastNode;
	}
}




