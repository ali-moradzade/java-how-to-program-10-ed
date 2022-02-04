package ThreeLetterStringsFromFiveLetterWord;

public class CreateString
{
	public static String[] create(String word)
	{
		String[] result = new String[
			word.length() * (word.length() - 1) * (word.length() - 2)];
		int count = 0;
		
		for (int i = 0; i < word.length(); i++)
		{
			for (int j = 0; j < word.length(); j++)
			{
				for (int k = 0; k < word.length(); k++)
				{
					if (!(i == j || i == k || j == k))
					{
						result[count] = String.valueOf(word.charAt(i)) + word.charAt(j) +
							word.charAt(k);
						count++;
					}
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) 
	{
		String[] result = create("bathe");
		
		for (String string : result)
		{
			System.out.println(string);
		}
	}
}
