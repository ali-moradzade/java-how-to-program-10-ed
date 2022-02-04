public class HugeIntegerTest
{
	public static void main(String[] args)
	{
		HugeInteger integer1 = new HugeInteger();
		integer1.parse("123456789");
		System.out.println(integer1);
		
		HugeInteger integer2 = new HugeInteger();
		integer2.parse("123456789");
		System.out.println(integer2);
		
		System.out.println(integer1.add(integer2));
	}
}
