package task5;

import java.util.HashMap;

public class _HashMap
{
	private HashMap<String, Integer> hashMap = new HashMap<>();
	
	public void Add(String name, int number)
	{
		hashMap.put(name, number);
		System.out.println(name + ", " + number + " added");
	}
	
	public void Remove(String key)
	{
		if(hashMap.containsKey(key))
		{			
			hashMap.remove(key);
			System.out.println(key + " removed");
		}
		else
		{
			System.out.println("Key doesnot exist");
		}
	}
	
	public void Display()
	{
		System.out.println("Key-Value pairs in the HashMap:");
		for (String key : hashMap.keySet())
		{
			System.out.println(key + ": " + hashMap.get(key));
		}
	}
}
