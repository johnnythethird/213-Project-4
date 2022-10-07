package application;
/**
This class is the main controller for the application which will allow the user
to pick any of the 3 pizza flavors and customize them. The user will have to input a 
phone number before the customization can begin. The user can also get a list of the current
order and a list of all the orders placed.
@author Johnny Gatlin, Sulaiman Khaliq
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainController 
{
	Order o = new Order();
	
	public static List<String> orders = new ArrayList<String>();
	
	public static List<List<String>> storeOrders = new ArrayList<List<String>>();
	
	public static List<String> phoneList = new ArrayList<String>();
	
	public static String currentNumber;
	
	private String previousNumber;
	
	@FXML
    private TextField phoneNumber;
	
    @FXML
    private Button currentOrder;

    @FXML
    private Button deluxeButton;

    @FXML
    private Button hawaiianButton;

    @FXML
    private Button pepperoniButton;

    @FXML
    private ImageView pizzaDeluxe;

    @FXML
    private ImageView pizzaHawaiian;

    @FXML
    private ImageView pizzaPepperoni;

    @FXML
    private Button storeOrder;
    
    /*
     This method will switch to the deluxe pizza customization screen and 
     the user will be able to edit that specific pizza to their liking. The phone
     number is saved for the order.
     */
    public void switchToCustom1(ActionEvent event) throws IOException
    {
    	if (phoneNumber.getText().matches("\\d{10}"))
    	{
    		if (!phoneNumber.getText().equals(previousNumber))
    		{
    			orders.clear(); // If this is not the same number, clear the order on entry.
    		}
    		
    		currentNumber = phoneNumber.getText();
    		
    		previousNumber = phoneNumber.getText();
    		
    		o.setCurrentNumber(phoneNumber.getText()); // This won't save. How can I keep the information?
    		
	    	try // Open the second scene with deluxe attributes.
	    	{
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/CustomizeView.fxml"));
	            Parent root = (Parent) fxmlLoader.load();
	            
	            CustomizeController custom = fxmlLoader.getController();
	            custom.saveNumber(phoneNumber.getText());
	            custom.switchToDeluxe();
	            
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root));  
	            stage.setTitle("Customize Pizza Menu");
	            stage.show();
	        } catch(Exception e) 
	    	{
	            e.printStackTrace();
	        }
    	}
    	else 
    	{
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Invalid Field");
    		alert.setHeaderText("Please enter a valid phone number");
    		alert.setContentText("Follow the format 'XXX-XX-XXXX'");
    		alert.showAndWait();
		}
    }
    
    /*
    This method will switch to the hawaiian pizza customization screen and 
    the user will be able to edit that specific pizza to their liking. The phone
    number is saved for the order.
    */
    public void switchToCustom2(ActionEvent event) throws IOException
    {
    	if (phoneNumber.getText().matches("\\d{10}"))
    	{
    		if (!phoneNumber.getText().equals(previousNumber))
    		{
    			orders.clear(); // If this is not the same number, clear the order on entry.
    		}
    		
    		currentNumber = phoneNumber.getText();
    		
    		previousNumber = phoneNumber.getText();
    		
    		o.setCurrentNumber(phoneNumber.getText()); // This won't save. How can I keep the information?
    		
	    	try // Open the second scene with hawaiian attributes.
	    	{
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/CustomizeView.fxml"));
	            Parent root = (Parent) fxmlLoader.load();
	            
	            CustomizeController custom = fxmlLoader.getController();
	            custom.saveNumber(phoneNumber.getText());
	            custom.switchToHawaiian();
	            
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root));  
	            stage.setTitle("Customize Pizza Menu");
	            stage.show();
	        } catch(Exception e) 
	    	{
	            e.printStackTrace();
	        }
    	}
    	else 
    	{
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Invalid Field");
    		alert.setHeaderText("Please enter a valid phone number");
    		alert.setContentText("Follow the format 'XXX-XX-XXXX'");
    		alert.showAndWait();
		}
    }
    
    /*
    This method will switch to the pepperoni pizza customization screen and 
    the user will be able to edit that specific pizza to their liking. The phone
    number is saved for the order.
    */
    public void switchToCustom3(ActionEvent event) throws IOException
    {
    	if (phoneNumber.getText().matches("\\d{10}"))
    	{
    		if (!phoneNumber.getText().equals(previousNumber))
    		{
    			orders.clear(); // If this is not the same number, clear the order on entry.
    		}
    		
    		currentNumber = phoneNumber.getText();
    		
    		previousNumber = phoneNumber.getText();
    		
    		o.setCurrentNumber(phoneNumber.getText());
    		
	    	try // Open the second scene with pepperoni attributes.
		    	{
		            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/CustomizeView.fxml"));
		            Parent root = (Parent) fxmlLoader.load();
		            
		            CustomizeController custom = fxmlLoader.getController();
		            custom.saveNumber(phoneNumber.getText());
		            custom.switchToPepperoni();
		            
		            Stage stage = new Stage();
		            stage.setScene(new Scene(root));  
		            stage.setTitle("Customize Pizza Menu");
		            stage.show();
		        } catch(Exception e) 
		    	{
		            e.printStackTrace();
		        }
	    	}
	    	else 
	    	{
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setTitle("Invalid Field");
	    		alert.setHeaderText("Please enter a valid phone number");
	    		alert.setContentText("Follow the format 'XXX-XX-XXXX'");
	    		alert.showAndWait();
			}
    }
    
    /*
    This method will switch to the current order menu where the user
    will be able to edit the current order by removing any pizzas and the total
    for the order will be displayed. The user can also place the order for the phone number.
    */
    public void switchToCurrent(ActionEvent event) throws IOException
    {
    	currentNumber = phoneNumber.getText();
    	try 
    	{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/CurrentOrderView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setTitle("Current Order Menu");
            stage.show();
        } catch(Exception e) 
    	{
            e.printStackTrace();
        }
    }
    
    /*
    This method will switch to the store order menu where the user
    can view all of the orders that were placed. The user will be able to
    remove certain orders and get the total for all of them. The user can
    also export the orders to a seperate text file.
    */
    public void switchToStoreOrder(ActionEvent event) throws IOException
    {
    	try 
    	{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/StoreOrderView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setTitle("Store Order Menu");
            stage.show();
        } catch(Exception e) 
    	{
            e.printStackTrace();
        }
    }
}
