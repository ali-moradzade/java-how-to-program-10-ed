package SetTest;

import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;

public class SetTest
{
	public static void main(String[] args)
	{
		String[] colors = {"red", "white", "blue", "green", "gray", "orange", 
			"tan", "white", "cyan", "peach", "gray", "orange"};
		List<String> list = Arrays.asList(colors);
		
		Collections.sort(list);
		System.out.printf("List: %s%n", list);
		
		printNonDuplicate(list);
	}
	
	private static void printNonDuplicate(Collection<String> values)
	{
		Set<String> set = new HashSet<>(values);

		System.out.printf("%nNonduplicates are: ");
		
		for (String value : set)
		{
			System.out.printf("%s ", value);
		}
	
		System.out.println();
	}
}
