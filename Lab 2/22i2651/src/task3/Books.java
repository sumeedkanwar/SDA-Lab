package task3;

public class Books implements Product
{
	String name;
	Double price;
	String description;
	
	public Books(String name, Double price, String description)
	{
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public String getName()
	{
		return name;
	}
	public Double getPrice()
	{
		return price;
	}
	public String getDescription()
	{
		return description;
	}

}
