package application;
/**
This is an main class for the pizza object and holds all the inheritor
flavors. This class allows the user to use methods that will edit the pizza 
that they are currently making.
@author Johnny Gatlin, Sulaiman Khaliq
*/

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public abstract class Pizza
{
	protected List<Topping> toppings = new ArrayList<Topping>();
	protected List<Topping> removedToppings = new ArrayList<Topping>();
	protected Size size; // Enum Class
	public abstract double price();
	
	DecimalFormat df = new DecimalFormat("#.##");
	
	/*
	 String method for all of the pizza objects that are 
	 created by the user. The inheritors use this along with their
	 own version.
	 */
	@Override
	public String toString()
	{
		return " " + getToppings().toString() + ", " + size + ", $" + df.format(price());
	}
	
	/*
	 This method will add the topping the user wants to put
	 on the pizza. It will add the topping to the list and remove 
	 the topping from the unused toppings.
	 */
    public void addTopping(Topping topping) 
    {
        toppings.add(topping);
        removedToppings.remove(topping);
    }

    /*
	 This method will remove the topping the user wants to get rid of
	 on the pizza. It will add the topping to the unused list and remove 
	 the topping from the toppings list.
	 */
    public void removeTopping(Topping topping) 
    {
        toppings.remove(topping);
        removedToppings.add(topping);
    }
    
    /*
	 This method will set the size of the current pizza.
	 */
    public Size setSize(Size size)
    {
    	return this.size = size;
    }
    
    /*
	 This method will get the size of the current pizza.
	 */
    public Size getSize()
    {
    	return size;
    }
    
    /*
	 This method will get the toppings that are on the pizza.
	 */
    public List<Topping> getToppings() 
    {
        return toppings;
    }
    
    /*
	 This method will get the toppings that are not on the pizza.
	 */
    public List<Topping> getRemovedToppings() 
    {
        return removedToppings;
    }
}
