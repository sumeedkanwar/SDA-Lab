package pkg;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Account aa1 = new Account(01, 1000.0, "current");
		Account aa2 = new Account(02, 10000.0, "saving");
		
		Customer Cust = new Customer(001, "Sumeed", aa1, aa2);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter value to withdraw from Currrent Account");
		Double cash = input.nextDouble();
		Cust.a1.Withdraw(cash);
		
		System.out.println("Enter value to deposit in Saving Account");
		cash = input.nextDouble();
		Cust.a2.Deposit(cash);
		
		input.close();
		
		
	}
}
