package isequalto;

public class IsEqualTo
{
	public static <T> boolean isEqualTo(T o1, T o2)
	{
		return o1.equals(o2);
	}
	
	public static void main(String[] args)
	{
		Integer one = 1;
		Integer two = 2;
		
		Object s1 = "hello";
		Object s2 = "hello";
		
		System.out.printf("isEqualTo(one, two): %b%n", isEqualTo(one, two));
		System.out.printf("isEqualTo(s1, s2): %b%n", isEqualTo(s1, s2));
	}
}





