package task3;

public class Main {
	public static void main(String[] args)
	{
		Product laptop = new Electronics("Laptop", 250000.0, "MSI Sword");
		Product book = new Books("Rich Dad, Poor Dad", 1000.0, "Financial Freedom Book");
        Product tShirt = new Clothing("T-Shirt", 1500.0, "Outfitters Black T-Shirt");

        Customer customer = new Customer("Sumeed", "sumeedkanwar@gmail.com", "DHA");

        OnlineOrder order1 = new OnlineOrder();
        order1.addProduct(laptop, 1);
        order1.addProduct(book, 1);

        OnlineOrder order2 = new OnlineOrder();
        order2.addProduct(tShirt, 10);
        
        customer.placeOrder(order1);
        customer.placeOrder(order2);
        
        customer.viewOrderHistory();
		
	}
}
