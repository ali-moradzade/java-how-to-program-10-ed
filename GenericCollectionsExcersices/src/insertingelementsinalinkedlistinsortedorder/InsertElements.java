package insertingelementsinalinkedlistinsortedorder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class InsertElements
{
	public static void main(String[] args)
	{
		Random random = new Random();
		List<Integer> list = new LinkedList<>();
		
		System.out.println("Adding 20 random elements in range 0-100 to list:");
		
		for (int i = 0; i < 20; i++)
		{
			list.add(random.nextInt(100));
			printList(list);
		}
	}
	
	private static void printList(List<Integer> list)
	{
		Collections.sort(list);
		System.out.printf("%nList contents are: ");
		int count = 0;
		
		for (Integer element : list)
		{
			System.out.printf("%s ", element);
			count += element;
		}
		
		System.out.printf("%n%s: %d%n%s: %d%n%s: %.2f%n",
			"Size of list", list.size(),
			"Sum of elements", count,
			"Average of list elements", (double) count / list.size());
	}
}
