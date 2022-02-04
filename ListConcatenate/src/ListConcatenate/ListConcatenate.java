package ListConcatenate;

public class ListConcatenate
{
	public static void concatenate(List<Character> list1, 
		List<Character> list2)
	{
		list1.getLastNode().nextNode = list2.getFirstNode();
	}
}



