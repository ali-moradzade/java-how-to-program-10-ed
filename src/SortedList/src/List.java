class ListNode<T extends Comparable<T>>
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
	
public class List<T extends Comparable<T>>
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
	
	public void insert(T insertItem)
	{
		if (isEmpty())
			firstNode = lastNode = new ListNode<>(insertItem);
		else
		{
			ListNode<T> current = firstNode;
			
			while (!isProperNode(current, insertItem))
			{
				current = current.nextNode;
			}
			
			ListNode<T> addedItem = new ListNode<>(insertItem, current.nextNode);
			
			if (current == lastNode)
			{
				lastNode = lastNode.nextNode = addedItem;
			}
			else
			{
				current.nextNode = addedItem;
			}
		}
	}
	
	public boolean isProperNode(ListNode<T> node, T insertItem)
	{
		return node.data.compareTo(insertItem) < 0 && 
			(node.nextNode == null || node.nextNode.data.compareTo(insertItem) > 0);
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




