package copyingandreversinglinkedlist;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CopyingAndReversingLinkedList
{
	public static void main(String[] args)
	{
		Character[] characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
		List<Character> list1 = new LinkedList<>(Arrays.asList(characters));
		
		System.out.printf("list1 contents are: %s%n", list1);
		
		List<Character> list2 = new LinkedList<>(list1);
		Collections.reverse(list2);
		
		System.out.printf("list2 contents are: %s%n", list2);
	}
}
