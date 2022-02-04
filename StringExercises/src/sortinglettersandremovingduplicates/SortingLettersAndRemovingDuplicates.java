package sortinglettersandremovingduplicates;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SortingLettersAndRemovingDuplicates
{
	private static final String characters = 
		"abcdefghijklmnopqrstuvwxyz";
	private static final int NUMBER_OF_RANDOM_CHARS = 30;
	
	public static void main(String[] args)
	{
		Random random = new Random();
		
		List<Character> list = new LinkedList<>();
		
		for (int i = 0; i < NUMBER_OF_RANDOM_CHARS; i++)
		{
			list.add(characters.charAt(random.nextInt(characters.length())));
		}
		
		System.out.printf("Original list contents are: %s%n", list);
		
		System.out.printf("Sorted list in ascending order is: %s%n",
			list.stream()
				 .sorted()
				 .collect(Collectors.toList()));
		
		System.out.printf("Sorted list in descending order is: %s%n",
			list.stream()
				 .sorted(Comparator.reverseOrder())
				 .collect(Collectors.toList()));
		
		System.out.printf("List in descending order with duplicate removed: %s%n",
			list.stream()
				 .distinct()
				 .sorted(Comparator.reverseOrder())
				 .collect(Collectors.toList()));
	}
}
