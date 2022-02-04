package sortingwordswithtreeset;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Sorting
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a line of text and press Enter:");
		String line = input.nextLine();
		
		String[] tokens = 
			line.replaceAll("[^a-zA-Z']", " ").trim().toLowerCase().split("\\s");
		
		Set<String> tree = new TreeSet<>();
		
		for (String token : tokens)
		{
			tree.add(token);
		}
		
		System.out.printf("Sorted and non duplicate words: %s%n", tree);
	}
}
