package task3;

import java.util.ArrayList;

class OnlineOrder implements Order {
	
	ArrayList<Product> productslist;
	
	public OnlineOrder()
	{
		productslist = new ArrayList<>();
	}
	
	public void addProduct(Product product, int quantity)
	{
		if (quantity <= 0)
		{
			System.out.println("Invalid quantity");
			return;
		}
		
		for (int i = 0; i < quantity; i++)
		{
			productslist.add(product);  
		}
	}
	
	public void removeProduct(Product product, int quantity)
	{
		if (quantity <= 0)
		{
			System.out.println("Invalid quantity");
			return;
		}
		
		if (productslist.contains(product))
		{
			int availableQuantity = 0;
			for (Product tem: productslist)
			{
				if (tem.equals(product) )
				{
					availableQuantity++;
				}
			}
			
			if (availableQuantity >= quantity)
			{
				for (int i = 0; i < quantity; i++)
				{
					productslist.remove(product);
				}
			} else
			{
				System.out.println("Invalid quantity");
			}
		}
	}
	
	public void calculateTotal() {
		if (productslist.size() <= 0)
		{
			System.out.println("No product");
		}
		
		Double total = 0.0;
		for (Product tem : productslist) {
			total += tem.getPrice();
		}
		System.out.println("Total: " + total);
	}
}
