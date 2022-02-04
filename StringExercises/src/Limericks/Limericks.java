package Limericks;

import java.util.Random;

public class Limericks
{
	private static final String[] articles = 
		{"the", "a", "one", "some", "any"};
	private static final String[] nouns = 
		{"boy", "girl", "dog", "town", "car"};
	private static final String[] verbs = 
		{"drove", "jumped", "ran", "walked", "skipped"};
	private static final String[] prepositions =
		{"to", "from", "over", "under", "on"};
	
	private static final Random random = new Random();
	private static int rhymeIdentifier = 1;
	
	private static String makeSentence()
	{
		String result = new StringBuilder()
			.append(articles[random.nextInt(articles.length)])
			.append(" ")
			.append(nouns[random.nextInt(nouns.length)])
			.append(" ")
			.append(verbs[random.nextInt(verbs.length)])
			.append(" ")
			.append(prepositions[random.nextInt(prepositions.length)])
			.append(" ")
			.append(articles[random.nextInt(articles.length)])
			.append(" ")
			.append(nouns[rhymeIdentifier])
			.append(".").toString();
		
		char character = result.charAt(0);
		char upperCaseChar = Character.toUpperCase(character);
		
		result = result.replaceFirst(String.valueOf(character), 
			String.valueOf(upperCaseChar));
		
		return result;
	}
	
	public static String makeLimericks()
	{
		setRhymeIdentifier();
		String firstLine = makeSentence();
		String secondLine = makeSentence();
		String fourthdLine = makeSentence();
		
		setRhymeIdentifier();
		String thirdLine = makeSentence();
		String fifthLine = makeSentence();
		
		String result = new StringBuilder()
			.append(firstLine)
			.append("\n")
			.append(secondLine)
			.append("\n")
			.append(thirdLine)
			.append("\n")
			.append(fourthdLine)
			.append("\n")
			.append(fifthLine).toString();
		
		return result;
	}
	
	private static void setRhymeIdentifier()
	{
		rhymeIdentifier = random.nextInt(nouns.length);
	}
}
