package task1;

import java.util.LinkedList;

public class linkedList {
	private LinkedList<Integer> list = new LinkedList<>();

	public void addStart(int number)
	{
		list.addFirst(number);
		System.out.println(number + " added at the start of the list");
	}
	
	public void addEnd(int number)
	{
		list.addLast(number);
		System.out.println(number + " added at the end of the list");
	}
	
	public void display()
	{
		if (list.isEmpty())
		{
			System.out.println("List is empty");
		}
		else
		{			
			for (int i = 0; i < list.size(); i++)
			{
				System.out.println(list.get(i));
			}
		}
    }
}
