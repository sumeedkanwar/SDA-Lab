package task3;

public class Electronics implements Product
{
	String name;
	Double price;
	String description;
	
	public Electronics(String name, Double price, String description) {
		super();
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
