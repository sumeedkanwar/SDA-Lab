package task2;

import java.util.LinkedList;

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
			if(position > 0 && position <= list.size())
			{
				for (int i = position; i < list.size(); i++)
				{
					System.out.println(list.get(i));
				}
			}
			else
			{
				System.out.println("Invalid position");
			}
		}
		
        
    }
}
