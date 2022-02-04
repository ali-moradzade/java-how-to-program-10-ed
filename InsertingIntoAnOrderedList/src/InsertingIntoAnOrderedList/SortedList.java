package InsertingIntoAnOrderedList;

class ListNode<T extends Comparable<T>>
{
	T data;
	ListNode<T> nextNode;

	ListNode(T object)
	{
		this(object, null);
	}

	ListNode(T object, ListNode<T> node)
	{
		data = object;
		nextNode = node;
	}

	T getData()
	{
		return data;
	}
	
	ListNode<T> getNext()
	{
		return nextNode;
	}
}

public class SortedList<T extends Comparable<T>>
{
	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	private String name;
	
	public SortedList()
	{
		this("sorted list");
	}
	
	public SortedList(String listName)
	{
		name = listName;
		firstNode = lastNode = null;
	}
	
	public void insert(T insertItem)
	{
		if (isEmpty())
			firstNode = lastNode = new ListNode<>(insertItem);
		else
		{
			ListNode<T> current = firstNode;
			ListNode<T> prev = null;
			
			while (current != null && current.data.compareTo(insertItem) < 0)
			{
				prev = current;
				current = current.nextNode;
			}
			
			if (prev == null)
				firstNode = new ListNode<>(insertItem, firstNode);
			else if (current == null)
				lastNode = lastNode.nextNode = new ListNode<>(insertItem);
			else
				prev.nextNode = new ListNode<>(insertItem, current);
		}
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
}
