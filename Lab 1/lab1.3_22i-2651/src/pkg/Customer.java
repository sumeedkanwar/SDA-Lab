package pkg;

public class Customer {
	private int customerId;
	private String name;
	public Account a1;
	public Account a2;
	
	public Customer(int i, String n, Account acc1, Account acc2)
	{
		customerId = i;
		name = n;
		a1 = acc1;
		a2 = acc2;
	}
}
