package task4;

import java.util.LinkedList;
import java.util.Queue;

public class _Queue
{
	private Queue<Integer> queue = new LinkedList<>();
	
	public void Enqueue(int number)
	{
		queue.offer(number);
		System.out.println(number + " added to the queue");
		
	}
	
	public void Dequeue()
	{
		if (queue.isEmpty())
		{
			System.out.println("Queue is empty");
		}
		else
		{
			System.out.println(queue.poll() + " is removed from the queue");			
		}
	}
	
	public void findRear()
	{
		if (queue.isEmpty())
		{
			System.out.println("Queue is empty");
		}
		else
		{
			int lastNumber = -1;
			while(!queue.isEmpty())
			{
				lastNumber = queue.poll();
			}
			System.out.println(lastNumber + " was at the end of the queue");
		}
	}
	
	
}
