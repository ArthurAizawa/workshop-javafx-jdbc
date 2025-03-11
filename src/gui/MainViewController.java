package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable{
	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void OnActionMenuItemSeller() {
		System.out.println("MenuItemSeller");
	}
	@FXML
	public void OnActionMenuItemDepartment() {
		System.out.println("MenuItemDepartment");
	}
	@FXML
	public void OnActionMenuItemAbout() {
		System.out.println("MenuItemAbout");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
