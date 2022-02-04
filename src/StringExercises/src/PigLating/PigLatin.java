package PigLating;

public class PigLatin
{
	public static String makePigLatin(String englishText)
	{
		String[] tokens = englishText.trim().split("\\s+");
		StringBuilder buffer = new StringBuilder();
		
		for (String token : tokens)
		{
			char c = token.charAt(0);
			token = token.substring(1) + c + "ay" + " ";
			buffer.append(token);
		}
		
		return buffer.toString().trim();
	}
	
	public static void displayLating(String englishSentence)
	{
		System.out.println(makePigLatin(englishSentence));
	}
}
