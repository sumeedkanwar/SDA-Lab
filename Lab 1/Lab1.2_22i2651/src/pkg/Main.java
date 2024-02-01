package pkg;

public class Main {

	public static void main(String[] args) {
		Book b1 = new Book("Freedom", "Sumeed", 2003);
		Book b2 = new Book("100 ways to die", "Rafay", 2004);
		
		if (b1.getYear() == b2.getYear())
		{
			System.out.println("Both are published in same year");
		}
		else if (b1.getYear() < b2.getYear())
		{
			System.out.println(b1.getName() + " was published earlier");
		}
		else
		{
			System.out.println(b2.getName() + " was published earlier");
		}
		
		b1.Display();
		b2.Display();
	}
}
