public class Test
{
	public static void main(String[] args)
	{
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		
		set1.insertElement(1);
		set1.insertElement(2);
		set1.insertElement(3);
		set1.insertElement(4);
		set1.insertElement(5);
		set1.insertElement(6);
		
		set2.insertElement(5);
		set2.insertElement(6);
		set2.insertElement(7);
		set2.insertElement(8);
		set2.insertElement(9);
		
		System.out.printf("set1: %s%n", set1);
		System.out.printf("set2: %s%n", set2);
		System.out.printf("union: %s%n", IntegerSet.union(set1, set2));
		System.out.printf("intersection: %s%n", IntegerSet.intersection(set1, set2));
	}
}
