package application;
/**
This is an maker class that will create instances of the pizza class.
This will specifically create the inheritors of the pizza class so that the 
customization menu can keep track of the pizza being made. 
@author Johnny Gatlin, Sulaiman Khaliq
*/

public class PizzaMaker 
{

	/*
	 This method is the creator for the user to create
	 the pizza that they are making. It will return the specific
	 that can be edited by the user. 
	 */
	public static Pizza createPizza(String flavor)
	{
		if (flavor.equals("deluxe"))
		{
			PizzaDeluxe d = new PizzaDeluxe();
			return d;
		}
		else if (flavor.equals("hawaiian"))
		{
			PizzaHawaiian h = new PizzaHawaiian();
			return h;
		}
		else if (flavor.equals("pepperoni"))
		{
			PizzaPepperoni p = new PizzaPepperoni();
			return p;
		}
		return null;
	}

}
