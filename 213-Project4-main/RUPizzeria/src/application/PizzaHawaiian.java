package application;
/**
This is an inheritor class that will inherit all of the attributes
of the main Pizza class. This specific property is hawaiian and has
all of the traits that come with the flavor.
@author Johnny Gatlin, Sulaiman Khaliq
*/

import java.util.Arrays;

public class PizzaHawaiian extends Pizza
{
	/*
	 Contructor method for the hawaiian flavor. This will start the pizza
	 with the specified toppings so that the user can remove or add other
	 toppings to the pizza.
	 */
	public PizzaHawaiian() 
	{
        toppings.addAll(Arrays.asList(Topping.Pinapple, Topping.Ham));
        removedToppings.addAll(Arrays.asList(Topping.Chicken, Topping.Beef, Topping.Sausage, Topping.Pepperoni, Topping.BlackOlives, Topping.Onion, Topping.Mushroom, Topping.GreenPepper));
    }
	
	/*
	 String method for the hawaiian class.
	 */
	@Override
	public String toString()
	{
		return "Hawaiian pizza," + super.toString();
	}
	
	/*
	 This method will get the price of the pizza
	 with all the specifications that the user has put on
	 the pizza. The price will calculate and return with the final 
	 number.
	 */
	@Override
	public double price() 
	{
		double basePrice = 10.99, addedTopping = 1.49, size = 0;
		
		if (getSize() == Size.Small)
		{
			size = 0;
		}
		else if (getSize() == Size.Medium)
		{
			size = 2;
		}
		else if (getSize() == Size.Large)
		{
			size = 4;
		}
		
		if (toppings.size() <= 2)
		{
			return basePrice + size;
		}
		else if (toppings.size() > 2)
		{
			return basePrice + size + (addedTopping * (toppings.size() - 2));
		}
			
		return 0;
	}
}
