package SortedSetTest;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest
{
	public static void main(String[] args)
	{
		String[] colors = {"yellow", "green", "black", "tan", "grey", "whtie",
			"orange", "red", "green"};
		SortedSet<String> tree = new TreeSet<>(Arrays.asList(colors));
		
		System.out.print("Sorted set: ");
		printSet(tree);
		
		System.out.print("headSet (\"orange\"): ");
		printSet(tree.headSet("orange"));
		
		System.out.print("tailSet (\"orange\"): ");
		printSet(tree.tailSet("orange"));
		
		System.out.printf("%s%n%s%n",
			tree.first(),
			tree.last());
	}
	
	private static void printSet(SortedSet<String> set)
	{
		for (String s : set)
		{
			System.out.printf("%s ", s);
		}
		
		System.out.println();
	}
}
