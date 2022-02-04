package bucketsorttest;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSortTest
{
	// sorts data in range 0-100
	public static void bucketSort(int[] data)
	{
		List<Integer>[] buckets = new LinkedList[10];
		
		for (int i = 0; i < 10; i++)
		{
			buckets[i] = new LinkedList<>();
		}
		
		for (int value : data)
		{
			buckets[value / 10].add(value);
		}
		
		int index = 0;
		
		for (List<Integer> bucket : buckets)
		{
			Collections.sort(bucket);
			
			for (int i = 0; i < bucket.size(); i++)
			{
				data[index++] = bucket.get(i);
			}
		}
	}
	
	public static void main(String[] args)
	{
		SecureRandom generator = new SecureRandom();
		int[] data = new int[10];
		
		for (int i = 0; i < data.length; i++)
		{
			data[i] = 10 + generator.nextInt(90);
		}
		
		System.out.printf("Unsorted array:%n%s%n%n", Arrays.toString(data));
		bucketSort(data);
		
		System.out.printf("Sorted array:%n%s%n%n", Arrays.toString(data));
	}
}










