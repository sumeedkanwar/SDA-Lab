package pkg;

public class Account {
	private int accountNumber;
	private Double balance;
	private String accountType;
	
	public Account(int n, Double b, String t)
	{
		accountNumber = n;
		balance = b;
		accountType = t;
	}
	
	public void Deposit(Double n)
	{
		balance += n;
		System.out.println("New balance = " + balance);
	}
	
	public void Withdraw(Double n)
	{
		if (balance < n)
		{
			System.out.println("Not enough funds");
		}
		else
		{
			System.out.println("Amount withdrawed");
			balance -= n;
			System.out.println("New balance = " + balance);
		}
	}
	
	public void Dsiplay()
	{
		System.out.println("Account Number = " + accountNumber);
		System.out.println("Balance = " + balance);
		System.out.println("Account Type = " + accountType);
	}
}
