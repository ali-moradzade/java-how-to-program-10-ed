package RandomSentences;

import java.util.Random;

public class RandomSentences
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
	
	public static String makeSentence()
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
			.append(nouns[random.nextInt(nouns.length)])
			.append(".").toString();
		
		char character = result.charAt(0);
		char upperCaseChar = Character.toUpperCase(character);
		
		result = result.replaceFirst(String.valueOf(character), 
			String.valueOf(upperCaseChar));
		
		return result;
	}
}
