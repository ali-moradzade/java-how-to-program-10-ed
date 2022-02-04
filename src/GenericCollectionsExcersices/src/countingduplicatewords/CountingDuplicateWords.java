package countingduplicatewords;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CountingDuplicateWords
{
	public static void main(String[] args)
	{
		Map<String, Integer> myMap = new HashMap<>();
		
		createMap(myMap);
		displayMap(myMap);
	}
	
	private static void createMap(Map<String, Integer> map)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string:");
		String line = scanner.nextLine();
		
		String[] tokens =
			line.replaceAll("[^a-zA-Z0-9']", " ").trim().toLowerCase().split("\\s+");
		
		for (String token : tokens)
		{
			if (map.containsKey(token))
			{
				int count = map.get(token);
				map.put(token, count + 1);
			}
			else
				map.put(token, 1);
		}
	}
	
	private static void displayMap(Map<String, Integer> map)
	{
		Set<String> sortedKeys = new TreeSet<>(map.keySet());
		
		System.out.printf("%nMap contains:%nKey\t\tValue%n");
		
		for (String key : sortedKeys)
		{
			System.out.printf("%-10s%10s%n", key, map.get(key));
		}
		
		System.out.printf("%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
	}
}
