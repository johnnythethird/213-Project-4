package application;
/**
This is an inheritor class that will inherit all of the attributes
of the main Pizza class. This specific property is pepperoni and has
all of the traits that come with the flavor.
@author Johnny Gatlin, Sulaiman Khaliq
*/

import java.util.Arrays;

public class PizzaPepperoni extends Pizza
{
	/*
	 Contructor method for the pepperoni flavor. This will start the pizza
	 with the specified toppings so that the user can remove or add other
	 toppings to the pizza.
	 */
	public PizzaPepperoni() 
	{
        toppings.addAll(Arrays.asList(Topping.Pepperoni));
        removedToppings.addAll(Arrays.asList(Topping.Chicken, Topping.Beef, Topping.Ham, Topping.Pinapple, Topping.BlackOlives, Topping.Onion, Topping.Mushroom, Topping.GreenPepper, Topping.Sausage));
    }
	
	/*
	 String method for the pepperoni class.
	 */
	@Override
	public String toString()
	{
		return "Pepperoni pizza," + super.toString();
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
		double basePrice = 8.99, addedTopping = 1.49, size = 0;
		
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
		
		if (toppings.size() <= 1)
		{
			return basePrice + size;
		}
		else if (toppings.size() > 1)
		{
			return basePrice + size + (addedTopping * (toppings.size() - 1));
		}
		
		return 0;
	}
}
