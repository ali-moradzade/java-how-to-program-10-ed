package StringMethods;

public class StringMethods
{
	public static int indexOf(String src, String str, int fromIndex)
	{
		if (str.length() > src.length())
			return -1;
		
		for (int i = fromIndex; i < src.length() - str.length() + 1; i++)
		{
			if (src.substring(i, i + str.length()).equals(str))
				return i;
		}
		
		return -1;
	}
	
	public static int indexOf(String src, String str)
	{
		return indexOf(src, str, 0);
	}
	
	public static int indexOf(String src, char c)
	{
		return indexOf(src, String.valueOf(c));
	}
	
	public static int indexOf(String src, char c, int fromIndex)
	{
		return indexOf(src, String.valueOf(c), fromIndex);
	}
	
	public static int lastIndexOf(String src, String str, int fromIndex)
	{
		if (src.length() < str.length())
			return -1;
		
		if (fromIndex > src.length() - str.length())
			return -1;
		
		for (int i = fromIndex; i >= 0; i--)
		{
			if (src.substring(i, i + str.length()).equals(str))
				return i;
		}
		
		return -1;
	}
	
	public static int lastIndexOf(String src, String str)
	{
		return lastIndexOf(src, str, src.length() - str.length());
	}
	
	public static int lastIndexOf(String src, char c, int fromIndex)
	{
		return lastIndexOf(src, String.valueOf(c), fromIndex);
	}
	
	public static int lastIndexOf(String src, char c)
	{
		return lastIndexOf(src, c, src.length() - 1);
	}
	
	public static void main(String[] args) 
	{
		String src = "abcdefghabcdefgh";
		String str = "ab";
		
		System.out.printf("%s%n%s%n%d%n",
			src, str, lastIndexOf(src, str, 8));
	}
}
