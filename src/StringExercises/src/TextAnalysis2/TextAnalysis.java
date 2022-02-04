package TextAnalysis2;
import java.util.Scanner;
import java.util.LinkedList;

public class TextAnalysis
{
	private static final LinkedList<String> strings = new LinkedList<>();
	private static final LinkedList<Integer> integers = new LinkedList<>();
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a line of text:");
		String line = input.nextLine();
		
		System.out.printf("%nPorcessed text information is:%n");
		processDifferentWord(line);
		display();
	}
	
	public static void processDifferentWord(String line)
	{
		String[] tokens =
			line.replaceAll("[^a-zA-Z0-9]", " ").trim().toLowerCase().split("\\s+");
		
		for (String token : tokens)
		{
			if (strings.contains(token) == false)
			{
				strings.add(token);
				integers.add(1);
			}
			else
			{
				int index = strings.indexOf(token);
				int length = integers.get(index);
				integers.set(index, length + 1);
			}
		}
	}
	
	public static void display()
	{
		for (int i = 0; i < strings.size(); i++)
		{
			System.out.printf("%s: %d%n", strings.get(i), integers.get(i));
		}
	}
}