package task3;

import java.util.Stack;

public class _Stack
{
	private Stack<Integer> stack = new Stack<>();
	
	
	public void add(int number)
	{
		stack.push(number);
		System.out.println(number + " added to stack");
	}
	
	public void displayTop()
	{
		if (stack.isEmpty())
		{
			System.out.println("Stack is empty");
		}
		else
		{
			System.out.println(stack.peek() + " is on top of the stack");			
		}
	}
	
	public void displayLast()
	{
		if (stack.isEmpty())
		{
			System.out.println("Stack is empty");
		}
		else
		{
			int lastNumber = -1;
			while(!stack.isEmpty())
			{
				lastNumber = stack.pop();
			}
			System.out.println(lastNumber + " was at the end of the stack");
		}
		
	}
	
	
}
