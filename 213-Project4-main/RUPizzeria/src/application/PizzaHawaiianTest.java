package application;
/**
This class is a test class for the hawaiian pizza class which will test the price() method.
@author Johnny Gatlin, Sulaiman Khaliq
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PizzaHawaiianTest 
{
	@Test
	public void testPrice() 
	{
		PizzaHawaiian p = new PizzaHawaiian();
		
		System.out.println(p.price()); // Test case 1: Expected to print 10.99
		
		// Add one topping
		p.addTopping(Topping.Mushroom);
		
		System.out.println(p.price()); // Test case 2: Expected to print 12.48
		
		// Add two more toppings
		p.addTopping(Topping.BlackOlives);
		p.addTopping(Topping.Chicken);
		
		System.out.println(p.price()); // Test case 3: Expected to print 15.46
		
		// Remove one topping
		p.removeTopping(Topping.Mushroom);
		
		System.out.println(p.price()); // Test case 4: Expected to print 13.97
		
		// Remove all toppings
		p.removeTopping(Topping.Chicken);
		p.removeTopping(Topping.BlackOlives);
		p.removeTopping(Topping.Ham);
		p.removeTopping(Topping.Pinapple);
		
		System.out.println(p.price()); // Test case 5: Expected to print 10.99
	}

}
