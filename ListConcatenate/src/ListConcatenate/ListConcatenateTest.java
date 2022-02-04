package ListConcatenate;

public class ListConcatenateTest
{
	public static void main(String[] args)
	{
		Character[] charArray1 = {'h', 'e', 'l', 'l', 'o'};
		Character[] charArray2 = {'a', 'l', 'i', 'M', 'a', 's', 't', 'e', 'r'};
		
		List<Character> list1 = new List<>();
		List<Character> list2 = new List<>();
		
		for (Character character : charArray1)
		{
			list1.insertAtBack(character);
		}
		
		for (Character character : charArray2)
		{
			list2.insertAtBack(character);
		}
		
		System.out.println("list1 contains:");
		list1.print();
		
		System.out.printf("%nlist2 contains:%n");
		list2.print();
		
		ListConcatenate.concatenate(list1, list2);
		System.out.printf("%nConcatenated list contains:%n");
		list1.print();
	}
}



