package Sumeed.Task1;

import org.springframework.beans.factory.annotation.Autowired;

public class CoffeeShop {
    private Coffee coffee;

    @Autowired
    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public void serveCoffee() {
        if (coffee != null) {
            System.out.println("Coffee served: " + coffee.getDescription());
        } else {
            System.out.println("Coffee is null.");
        }
    }

}
