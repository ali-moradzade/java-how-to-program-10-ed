package DuplicateElimination;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateElimination
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Set<String> set = new HashSet<>();
		
		System.out.printf("%s%n%s%n? ",
			"Enter a series of first names.",
			"Enter end-of-file indicator to end input.");
		
		while (input.hasNext())
		{
			String firstName = input.next();
			System.out.print("? ");
			set.add(firstName);
		}
		
		printNames(set);
	}
	
	private static void printNames(Set<String> set)
	{
		System.out.printf("%nSet contents are:%n");
		
		Iterator<String> iterator = set.iterator();
		
		while (iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
