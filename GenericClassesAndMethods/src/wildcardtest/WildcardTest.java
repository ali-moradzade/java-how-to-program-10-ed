package wildcardtest;

import java.util.ArrayList;

public class WildcardTest
{
	public static void main(String[] args)
	{
		Integer[] integers = {1, 2, 3, 4, 5};
		ArrayList<Integer> integerList = new ArrayList<>();
		
		for (Integer element : integers)
		{
			integerList.add(element);
		}
		
		System.out.printf("integerList contains: %s%n", integerList);
		System.out.printf("Total of the elements in integerList: %.0f%n%n",
			sum(integerList));
		
		Double[] doubles = {1.1, 3.3, 5.5};
		ArrayList<Double> doubleList = new ArrayList<>();
		
		for (Double element : doubles)
		{
			doubleList.add(element);
		}
		
		System.out.printf("doubleList contains: %s%n", doubleList);
		System.out.printf("Total of the elements in doubleList: %.1f%n%n",
			sum(doubleList));
		
		Number[] numbers = {1, 2.4, 3, 4.1};
		ArrayList<Number> numberList = new ArrayList<>();
		
		for (Number element : numbers)
		{
			numberList.add(element);
		}
		
		System.out.printf("numberList contains: %s%n", numberList);
		System.out.printf("Total of the elements in numberList: %.1f%n",
			sum(numberList));
	}
	
	public static double sum(ArrayList<? extends Number> list)
	{
		double total = 0;
		
		for (Number element : list)
		{
			total += element.doubleValue();
		}
		
		return total;
	}
}



