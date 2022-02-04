package InsertingIntoAnOrderedList1;

import java.util.Random;

public class SortedListTest
{
	public static void main(String[] args)
	{
		SortedList<Integer> list = new SortedList<>();
		Random randomNumbers = new Random();
		
		for (int i = 0; i < 25; i++)
		{
			list.insert(randomNumbers.nextInt(100));
			list.print();
		}
	}
}
