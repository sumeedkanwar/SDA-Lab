package task4;

public class Main
{
	public static void main(String[] args)
	{
		_Queue queue = new _Queue();
		queue.findRear();
		queue.Dequeue();
		queue.Enqueue(0);
		queue.Enqueue(1);
		queue.Enqueue(2);
		queue.Enqueue(5);
		queue.Dequeue();
		queue.findRear();
	}
}
