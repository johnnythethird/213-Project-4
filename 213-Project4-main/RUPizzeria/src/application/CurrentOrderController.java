package application;
/**
This class is the controller for the current order menu in the application.
This class will allow the user to remove pizza from the current phone number and 
place an order so that can be finalize in the store order class. The user will also
be able to view the total price of the order.
@author Johnny Gatlin, Sulaiman Khaliq
*/

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CurrentOrderController extends CustomizeController 
{	
	private double total = 0, realNum = 0, taxes = 0, realTotal = 0;
	
	public static int index = 0;
	
	DecimalFormat df = new DecimalFormat("#.##");
	
	@FXML
    private TextField orderTotal;

    @FXML
    private ListView<String> pizzaOrders;

    @FXML
    private Button placeOrder;

    @FXML
    private Button removePizza;

    @FXML
    private TextField subtotal;

    @FXML
    private TextField tax;

    @FXML
    private TextField userPhoneNumber;
    
    /*
    This method is used to initialize all of the fields that require
    text. Will be be activated as soon as this menu is opened.
    */
    public void initialize(URL location, ResourceBundle resources) 
    {
        userPhoneNumber.setText(currentNumber);
        
        total = 0;
        
        java.util.List<String> pizzaOrderList = orders;
        
        for (int i = 0; i < pizzaOrderList.size(); i++)
    	{
    		pizzaOrders.getItems().addAll(pizzaOrderList.get(i));
    		String str = pizzaOrderList.get(i);
    		String numberOnly = str.replaceAll("[^0-9\\.]", "");
    		
    		realNum = Double.parseDouble(numberOnly);
    		total = total + realNum;
    	}
        
        taxes = total * 0.06625;
        
        realTotal = total + taxes;
        
        subtotal.setText(String.valueOf(total));
        tax.setText(String.valueOf(df.format(taxes)));
        orderTotal.setText(String.valueOf(df.format(realTotal)));
    }
    
    /*
    This method is used to remove the pizza that is currently being
    selected by the user. It will recalculate the total of the order once
    the pizza is removed.
    */
    public void removePizza(ActionEvent e)
    {
    	String current = pizzaOrders.getSelectionModel().getSelectedItem();
    	orders.remove(current);
    	pizzaOrders.getItems().clear();
    	
    	total = 0;
        
        java.util.List<String> pizzaOrderList = orders;
        
        for (int i = 0; i < pizzaOrderList.size(); i++)
    	{
    		pizzaOrders.getItems().addAll(pizzaOrderList.get(i));
    		String str = pizzaOrderList.get(i);
    		String numberOnly = str.replaceAll("[^0-9\\.]", "");
    		
    		realNum = Double.parseDouble(numberOnly);
    		total = total + realNum;
    	}
        
        taxes = total * 0.06625;
        
        realTotal = total + taxes;
        
        subtotal.setText(String.valueOf(total));
        tax.setText(String.valueOf(df.format(taxes)));
        orderTotal.setText(String.valueOf(df.format(realTotal)));;
        
        Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Pizza Removed");
		alert.setHeaderText("Pizza has been removed from order.");
		alert.setContentText("The price has been adjusted to match the current order.");
		alert.showAndWait();
    }
    
    /*
     This method will place the order for the current phone number
     and will store the order to the store order so that it can be 
     finalized later. It will check if the number is a duplicate and replace
     the order if necessary.
     */
    public void placeOrder(ActionEvent e)
    {
    	storeOrders.add(orders);
    	
    	orders = new ArrayList<String>(orders);
    	
    	phoneList.add(index + " " + userPhoneNumber.getText() + "=" + orderTotal.getText());
    	
    	String current = phoneList.get(index).substring(2, 12);
    	
    	// Check for duplicate number so we can delete it if necessary.
    	for (int i = 0; i < index; i++)
    	{
    		String sub = phoneList.get(i).substring(2, 12);
    		
    		if (current.equals(sub))
    		{	
    			storeOrders.remove(i);
    			phoneList.remove(i);
    	        return;
    		}
    	}

    	index++;
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Order Placed.");
		alert.setHeaderText("Order has been placed.");
		alert.setContentText("Check the store order menu to check your order.");
		alert.showAndWait();
    }
}
