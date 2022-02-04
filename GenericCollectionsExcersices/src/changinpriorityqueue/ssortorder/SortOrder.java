package changinpriorityqueue.ssortorder;

import java.util.Collections;
import java.util.PriorityQueue;

public class SortOrder
{

	public static void main(String[] args)
	{
		PriorityQueue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		
		queue.offer(3.2);
		queue.offer(9.8);
		queue.offer(5.4);
		
		System.out.print("Polling from queue: ");
		
		while (queue.size() > 0)
		{
			System.out.printf("%.1f ", queue.peek());
			queue.poll();
		}
	}
}
