package application;
/**
This class will be called by the controller class so that the text
file can be created and executed. This will allow the user to save all of
the orders that were created.
@author Johnny Gatlin, Sulaiman Khaliq
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class StoreOrders extends StoreOrderController
{
	/*
	This method is used to allow the user to export all of the orders
	that were created with the pizza maker. The text file will be stored wherever
	the user decides to put it.
	 */
	void export() throws FileNotFoundException
	{
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open Target File for the Export");
		chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("All Files", "*.*"));
		Stage stage = new Stage();
		File targetFile = chooser.showSaveDialog(stage); //get the reference of the target file
		
		PrintWriter pw = new PrintWriter(targetFile);
		
		for (int p = 0; p < index; p++)
    	{
    		String sub = phoneList.get(p).substring(2, 12);
    		pw.println(sub + ": ");
    		pizzaOrderList = storeOrders.get(p);
    		for (int w = 0; w < pizzaOrderList.size(); w++)
	    	{
    			pw.println(pizzaOrderList.get(w));
	    	}
    	}
		pw.close();
	}
}
