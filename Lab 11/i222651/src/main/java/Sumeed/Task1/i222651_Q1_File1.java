package Sumeed.Task1;

public class Coffee {
    private String type;
    private String size;
    private double price;

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter for displaying details
    public String getDescription() {
        return size + " " + type + " - $" + price;
    }
}