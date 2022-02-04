package LetterTypeCount;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Scanner;

public class LetterTypeCount
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
		System.out.println("Enter a line of text:");
		String input = scanner.nextLine();
		
		String[] tokens = input.trim().split("\\s+");
		
		for (String token : tokens)
		{
			String word = token.toLowerCase();
			
			for (int i = 0; i < word.length(); i++)
			{
				String key = String.valueOf(word.charAt(i));
				
				if (map.containsKey(key))
				{
					int count = map.get(key);
					map.put(key, count + 1);
				}
				else
					map.put(key, 1);
			}
		}
	}
	
	private static void displayMap(Map<String, Integer> map)
	{
		TreeSet<String> sortedKeys = new TreeSet<>(map.keySet());
		
		System.out.printf("%nMap contains:%nKey\t\tValue%n");
		
		for (String key : sortedKeys)
		{
			System.out.printf("%-10s%11s%n", key, map.get(key));
		}
		
		System.out.printf("%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
	}
}
