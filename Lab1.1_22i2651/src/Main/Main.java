package Main;
import java.util.Scanner;

public class Main {
	
	public static void main(String [] args)
		{
		int size = 5;
		int [] num = new int [5];
		Scanner input = new Scanner(System.in);
		
		
		for (int i = 0; i < size; i++)
		{
			System.out.println("Input number");
			num[i] = input.nextInt();
			
		}
		
		System.out.println("You entered");
		for (int i = 0; i < size; i++)
		{
			System.out.println(num[i]);			
		}
		input.close();
	}

}
