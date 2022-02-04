package duplicatewordremoval;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DuplicateWordRemoval
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a line of text:");
		String line = input.nextLine();
		
		System.out.printf("%nNon duplicate words in alphabetical order:%n");
		List<String> list = Arrays.asList(line.split("\\s+"));
		list.stream()
			 .distinct()
			 .sorted()
			 .forEach(System.out::println);
	}
}
