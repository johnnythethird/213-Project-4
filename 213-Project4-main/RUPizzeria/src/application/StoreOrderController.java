package application;
/**
This class is the controller of the store order menu in the application. This 
will keep track of the orders that were placed from the previous menus and the user
will be able to either delete an order of their choosing or export all of the orders
to a seperate text file. 
@author Johnny Gatlin, Sulaiman Khaliq
*/

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class StoreOrderController extends CurrentOrderController
{
	private ObservableList<String> numbers = FXCollections.observableArrayList();
	
	protected java.util.List<String> pizzaOrderList;
	
	private String sub, sub2;
	
	@FXML
    private Button cancelOrder;

    @FXML
    private Button exportOrder;

    @FXML
    private ComboBox<String> listPhoneNumbers;

    @FXML
    private TextField orderTotal;

    @FXML
    private ListView<String> pizzaList;
    
    /*
     This method is used to initialize all of the fields that require
     text. Will be be activated as soon as this menu is opened.
     */
    public void initialize(URL location, ResourceBundle resources) 
    {
    	for (int i = 0; i < index; i++)
    	{
    		String sub = phoneList.get(i).substring(2, 12);
    		numbers.add(sub);
    	}
    	listPhoneNumbers.setItems(numbers);
    	
    	orderTotal.setText("0.00");
    }
    
    /*
     This method will activate whenever the phone number is switched
     to a different number. It will reset all the text fields so that it
     can update with the information corresponding to the phone number selected.
     */
    public void switchPhoneNumber(ActionEvent e)
    {	
    	String current = listPhoneNumbers.getSelectionModel().getSelectedItem();
    	
    	if (current == null)
    	{
    		return;
    	}
    	
    	for (int i = 0; i < index; i++)
    	{
    		sub = phoneList.get(i).substring(2, 12);
    		
    		if (current.equals(sub))
    		{
    			pizzaList.getItems().clear();
    			
    			pizzaOrderList = storeOrders.get(i);
    	        
    	        for (int p = 0; p < pizzaOrderList.size(); p++)
    	    	{
    	    		pizzaList.getItems().addAll(pizzaOrderList.get(p));
    	    	}
    	        
    	        sub2 = phoneList.get(i).substring(phoneList.get(i).indexOf("=")+1); // total price
    	        break;
    		}
    	}
    	
    	orderTotal.setText(sub2);
    }
    
    /*
     This method will delete the currently selected phone number
     and update the list of phone numbers and orders so that everything
     still matches.
     */
    public void deleteOrder(ActionEvent e)
    {
    	String current = listPhoneNumbers.getSelectionModel().getSelectedItem();
    	
    	for (int i = 0; i < index; i++)
    	{
    		sub = phoneList.get(i).substring(2, 12);
    		
    		if (current.equals(sub))
    		{
    			pizzaList.getItems().clear();
    			
    			storeOrders.remove(i);
    			phoneList.remove(i);
    			index--;
    			
    			numbers.clear();
    			
    			for (int p = 0; p < index; p++)
    	    	{
    	    		String sub = phoneList.get(p).substring(2, 12);
    	    		numbers.add(sub);
    	    	}
    			listPhoneNumbers.setItems(numbers);
    			orderTotal.setText("0.00");
    			
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Order Deleted.");
    			alert.setHeaderText("Order has been deleted.");
    			alert.setContentText("Phone number and order have been discarded.");
    			alert.showAndWait();
    	        return;
    		}
    	}
    }
    
    /*
     This method will utilize the StoreOrder class so that it can
     call the export method and save the orders to a new text file.
     */
    public void exportOrder(ActionEvent e) throws FileNotFoundException
    {
    	StoreOrders ex = new StoreOrders();
    	ex.export();
    }
}
