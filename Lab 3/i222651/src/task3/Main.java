package task3;


public class Main
{
	public static void main(String[] args)
	{
		_Stack stack = new _Stack();
		stack.add(8);
		stack.add(2);
		stack.add(5);
		stack.add(4);
		stack.add(1);
		
		stack.displayTop();
		stack.displayLast();
	}
}
