package pkg;

public class Book {
	private String title;
	private String author;
	private int year;
	
	public Book(String t, String a, int y)
	{
		title = t;
		author = a;
		year = y;
	}
	
	public void Display()
	{
		System.out.println("Title = " + title);
		System.out.println("Author = " + author);
		System.out.println("Year = " + year);
	}
	
	public String getName()
	{
		return title;
	}
	
	public int getYear()
	{
		return year;
	}
}
