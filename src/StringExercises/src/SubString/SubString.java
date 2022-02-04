package SubString;

public class SubString
{
	public static void main(String[] args)
	{
		String letters = "abcdefghijklmabcdefghijklm";
		
		for (int i = 0; i < letters.length(); i++)
		{
			System.out.printf("%2d ", i);
		}
		
		System.out.println();
		
		for (int i = 0; i < letters.length(); i++)
		{
			System.out.printf("%2s ", letters.charAt(i));
		}
		
		System.out.printf("%n%nSubstring from index 20 to end is \"%s\"%n",
			letters.substring(20));
		System.out.printf("%s \"%s\"%n",
			"Substring from index 3 up to, but not including 6 is",
			letters.substring(3, 6));
	}
}
