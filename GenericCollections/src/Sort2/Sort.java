package Sort2;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Sort
{
	public static void main(String[] args)
	{
		List<Time> list = new ArrayList<>();
		
		list.add(new Time(6, 24, 34));
		list.add(new Time(18, 14, 58));
		list.add(new Time(6, 5, 34));
		list.add(new Time(12, 14, 58));
		list.add(new Time(6, 24, 22));
		
		System.out.printf("Unsorted array elements:%n%s%n", list);
		
		Collections.sort(list, new TimeComparator());
		System.out.printf("Sorted list elements:%n%s%n", list);
	}
}
