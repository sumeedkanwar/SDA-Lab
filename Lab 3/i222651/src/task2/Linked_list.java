package task2;

import java.util.LinkedList;
import java.util.ListIterator;

public class Linked_list
{
	private LinkedList<Integer> list = new LinkedList<>();
	
	public void add(int number)
	{
		list.add(number);
		System.out.println(number + " added to the list");
	}
	
	public void iterate(int position)
	{
		if (list.isEmpty())
		{
			System.out.println("List is empty");
		}
		else
		{			
			if (position > 0 && position <= list.size())
			{
                ListIterator<Integer> iterator = list.listIterator(position - 1);
                while (iterator.hasNext())
                {
                    System.out.println(iterator.next());
                }
			}
			else
			{
				System.out.println("Invalid position");
			}
		}
		
        
    }
}
