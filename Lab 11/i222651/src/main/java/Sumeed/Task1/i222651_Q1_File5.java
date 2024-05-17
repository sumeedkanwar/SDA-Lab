package Sumeed.Task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("coffeebeans.xml");
        CoffeeShop coffeeShop = (CoffeeShop) context.getBean("coffeeShop");
        coffeeShop.serveCoffee();
        coffeeShop = (CoffeeShop) context.getBean("CoffeeShop");
        coffeeShop.serveCoffee();
    }
}
