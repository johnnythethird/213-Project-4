package application;
/**
This class is the controller class for the customize menu and will allow the user
to customize the pizza for the current phone number. The user can add and remove toppings, 
change the size of the pizza, and place the pizza for order. 
@author Johnny Gatlin, Sulaiman Khaliq
*/

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CustomizeController extends MainController implements Initializable
{ 
	private Pizza userPizza;
	
	public String phoneNumber;
	
	DecimalFormat df = new DecimalFormat("#.##");
	
	@FXML
    private Button addOrder;
	
	@FXML
    private Button addTopping;
	
	@FXML
    private Button removeTopping;
	
	@FXML
    private TextArea totalPizzaPrice;
	
    @FXML
    private ListView<String> selectedToppings;
    
    @FXML
    private ListView<String> additionalToppings;
    
    @FXML
    private ImageView chosenPizza;
    
    @FXML
    private ComboBox<String> pizzaSize;
    
    private ObservableList<String> List = FXCollections.observableArrayList("Small", "Medium", "Large");
    
    Image pizza1 = new Image(getClass().getResourceAsStream("Images/DeluxePizza.png"));
    Image pizza2 = new Image(getClass().getResourceAsStream("Images/HawaiianPizza.png"));
    Image pizza3 = new Image(getClass().getResourceAsStream("Images/PepperoniPizza.png"));
    
    /*
     This initialize method will put the list for pizza sizes that are available
     to the user when they select the flavor they want.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        pizzaSize.setItems(List);
    }
    
    /*
     This method is used to display the image of the selected pizza and 
     display the attributes of the deluxe pizza. 
     */
	@SuppressWarnings("static-access")
	public void switchToDeluxe()
    {
    	chosenPizza.setImage(pizza1);
    	
    	PizzaMaker pizza = new PizzaMaker();
    	
    	userPizza = pizza.createPizza("deluxe");
    	
    	java.util.List<Topping> deluxeFlavor = userPizza.getToppings();
    	java.util.List<Topping> otherFlavor = userPizza.getRemovedToppings();
        
    	for (int i = 0; i < otherFlavor.size(); i++)
    	{
    		additionalToppings.getItems().addAll(otherFlavor.get(i).toString());
    	}
    	for (int i = 0; i < deluxeFlavor.size(); i++)
    	{
    		selectedToppings.getItems().addAll(deluxeFlavor.get(i).toString());
    	}
    	
    	String s = String.valueOf(userPizza.price());
    	totalPizzaPrice.setText(s);
    }
    
	/*
    This method is used to display the image of the selected pizza and 
    display the attributes of the hawaiian pizza. 
    */
    @SuppressWarnings("static-access")
	public void switchToHawaiian()
    {
    	chosenPizza.setImage(pizza2);
    	
    	PizzaMaker pizza = new PizzaMaker();
    	
    	userPizza = pizza.createPizza("hawaiian");
    	
    	java.util.List<Topping> deluxeFlavor = userPizza.getToppings();
    	java.util.List<Topping> otherFlavor = userPizza.getRemovedToppings();
        
    	for (int i = 0; i < otherFlavor.size(); i++)
    	{
    		additionalToppings.getItems().addAll(otherFlavor.get(i).toString());
    	}
    	for (int i = 0; i < deluxeFlavor.size(); i++)
    	{
    		selectedToppings.getItems().addAll(deluxeFlavor.get(i).toString());
    	}
    	
    	String s = String.valueOf(df.format(userPizza.price()));
    	totalPizzaPrice.setText(s);
    }
    
    /*
    This method is used to display the image of the selected pizza and 
    display the attributes of the pepperoni pizza. 
    */
    @SuppressWarnings("static-access")
	public void switchToPepperoni()
    {
    	chosenPizza.setImage(pizza3);
    	
    	PizzaMaker pizza = new PizzaMaker();
    	
    	userPizza = pizza.createPizza("pepperoni");
    	
    	java.util.List<Topping> deluxeFlavor = userPizza.getToppings();
    	java.util.List<Topping> otherFlavor = userPizza.getRemovedToppings();
        
    	for (int i = 0; i < otherFlavor.size(); i++)
    	{
    		additionalToppings.getItems().addAll(otherFlavor.get(i).toString());
    	}
    	for (int i = 0; i < deluxeFlavor.size(); i++)
    	{
    		selectedToppings.getItems().addAll(deluxeFlavor.get(i).toString());
    	}
    	
    	String s = String.valueOf(df.format(userPizza.price()));
    	totalPizzaPrice.setText(s);
    }
    
    /*
    This method is used to add the topping the user selected
    to the pizza. The price will change once the topping is changed.
    */
    public void addTopping(ActionEvent e)
    {
    	String current = additionalToppings.getSelectionModel().getSelectedItem();
    	Topping currentTopping = Topping.valueOf(current);
    	
    	java.util.List<Topping> deluxeFlavor = userPizza.getToppings();
    	
    	if (deluxeFlavor.size() == 7)
    	{
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Invalid Field");
    		alert.setHeaderText("Too many toppings.");
    		alert.setContentText("You can have a max of 7 toppings.");
    		alert.showAndWait();
    		return;
    	}
    	
    	userPizza.addTopping(currentTopping);
    	
    	deluxeFlavor = userPizza.getToppings();
    	java.util.List<Topping> otherFlavor = userPizza.getRemovedToppings();
        
    	additionalToppings.getItems().clear();
    	selectedToppings.getItems().clear();
    	
    	for (int i = 0; i < otherFlavor.size(); i++)
    	{
    		additionalToppings.getItems().addAll(otherFlavor.get(i).toString());
    	}
    	for (int i = 0; i < deluxeFlavor.size(); i++)
    	{
    		selectedToppings.getItems().addAll(deluxeFlavor.get(i).toString());
    	}
    	
    	String s = String.valueOf(df.format(userPizza.price()));
    	totalPizzaPrice.setText(s);
    }
    
    /*
    This method is used to remove the topping the user selected
    from the pizza. The price will change once the topping is changed.
    */
    public void removeTopping(ActionEvent e)
    {
    	String current = selectedToppings.getSelectionModel().getSelectedItem();
    	Topping currentTopping = Topping.valueOf(current);
    	
    	userPizza.removeTopping(currentTopping);
    	
    	java.util.List<Topping> deluxeFlavor = userPizza.getToppings();
    	java.util.List<Topping> otherFlavor = userPizza.getRemovedToppings();
        
    	additionalToppings.getItems().clear();
    	selectedToppings.getItems().clear();
    	
    	for (int i = 0; i < otherFlavor.size(); i++)
    	{
    		additionalToppings.getItems().addAll(otherFlavor.get(i).toString());
    	}
    	for (int i = 0; i < deluxeFlavor.size(); i++)
    	{
    		selectedToppings.getItems().addAll(deluxeFlavor.get(i).toString());
    	}
    	
    	String s = String.valueOf(df.format(userPizza.price()));
    	totalPizzaPrice.setText(s);
    }
    
    /*
    This method is used to switch the size of the pizza to whatever the user selected. 
    The price will change once the size is changed.
    */
    public void switchSize(ActionEvent e)
    {
    	double truePrice = 0;
    	String a;
    	Size small = Size.Small;
    	Size medium = Size.Medium;
    	Size large = Size.Large;
    			
    	String current = pizzaSize.getSelectionModel().getSelectedItem();
    	
    	if (current == "Small")
    	{
    		userPizza.setSize(small);
    		truePrice = userPizza.price();
    		a = String.valueOf(df.format(truePrice));
    		totalPizzaPrice.setText(a);
    	}
    	else if (current == "Medium")
    	{
    		userPizza.setSize(medium);
    		truePrice = userPizza.price();
    		a = String.valueOf(df.format(truePrice));
    		totalPizzaPrice.setText(a);
    	}
    	else if (current == "Large")
    	{
    		userPizza.setSize(large);
    		truePrice = userPizza.price();
    		a = String.valueOf(df.format(truePrice));
    		totalPizzaPrice.setText(a);
    	}
    }

    /*
    This method is used to add the order to the current phone number.
    */
    public void addOrder(ActionEvent e)
    {
    	String current = pizzaSize.getSelectionModel().getSelectedItem();
    	
    	if (current == null)
    	{
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Invalid Field");
    		alert.setHeaderText("Invalid Size.");
    		alert.setContentText("Please select a size from the dropdown menu.");
    		alert.showAndWait();
    		return;
    	}
    	
    	orders.add(userPizza.toString());
    	o.setCurrentOrder(userPizza);
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Pizza Added");
		alert.setHeaderText("Pizza has been added to the order.");
		alert.setContentText("Please go to the current order menu to confirm your order.");
		alert.showAndWait();
    }
    
    /*
    This method is used to save the current phone number of the order.
    */
    public String saveNumber(String string)
    {
    	phoneNumber = string;
    	return this.phoneNumber;
    }
    
    /*
    This method is used to get the current phone number of the order.
    */
    public String getNumber()
    {
    	return phoneNumber;
    }
}
