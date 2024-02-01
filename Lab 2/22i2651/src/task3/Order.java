package task3;

public interface Order
{
	void addProduct(Product product, int quantity);
	void removeProduct(Product product, int quantity);
	void calculateTotal();
}
