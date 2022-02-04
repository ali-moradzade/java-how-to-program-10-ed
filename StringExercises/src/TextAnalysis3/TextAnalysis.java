package TextAnalysis3;

public class TextAnalysis
{
	public static String convertToUpperCase(String camelCaseForm)
	{
		String character = findFirstUppercaseCharacter(camelCaseForm);
		
		while (character != null)
		{
			camelCaseForm = camelCaseForm.replaceFirst(
				character, "_" + character.toLowerCase());
			
			character = findFirstUppercaseCharacter(camelCaseForm);
		}
		
		return camelCaseForm.toUpperCase();
	}
	
	private static String findFirstUppercaseCharacter(String camelCaseForm)
	{
		for (int i = 0; i < camelCaseForm.length(); i++)
		{
			if (String.valueOf(camelCaseForm.charAt(i)).matches("[A-Z]"))
				return String.valueOf(camelCaseForm.charAt(i));
		}
		
		return null;
	}
	
	public static void main(String[] args) 
	{
		String string = "findFirstUppercaseCharacter";
		
		System.out.printf("%s-->%s%n", string, convertToUpperCase(string));
	}
}
