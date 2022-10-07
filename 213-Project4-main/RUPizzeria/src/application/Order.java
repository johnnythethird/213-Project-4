package application;
/**
This class will help keep track of all the orders and phone
numbers that the user will input in the application. This is mainly
used by the current menu controller before the user sets the order.
@author Johnny Gatlin, Sulaiman Khaliq
*/

import java.util.ArrayList;
import java.util.List;

public class Order 
{
	private String phone;
	private List<String> orders = new ArrayList<String>();
	
	/*
	 This method will set the current phone number.
	 */
	public String setCurrentNumber(String phone)
	{
		this.phone = phone;
		return phone;
	}
	
	/*
	 This method will get the current phone number.
	 */
	public String getCurrentNumber()
	{
		return phone;
	}
	
	/*
	 This method will set the pizza order that is currently being used.
	 */
	public List<String> setCurrentOrder(Pizza pizza)
	{
		orders.add(pizza.toString());
		return this.orders;
	}
	
	/*
	 This method will get the pizza order that is currently being used.
	 */
	public List<String> getCurrentOrder()
	{
		return orders;
	}
	
	/*
	 This method will clear the current order.
	 */
	public List<String> clearOrder()
	{
		orders.clear();
		return orders;
	}
}
