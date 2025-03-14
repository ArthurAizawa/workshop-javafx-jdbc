package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

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
		loadView("/gui/DepartmentView.fxml", (DepartmentListController controller) -> {
			controller.setDepartmentService(new DepartmentService());
			controller.updateTableView();
		});
	}
	@FXML
	public void OnActionMenuItemAbout() {
		loadView("/gui/About.fxml", x -> {});
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public synchronized <T> void loadView(String absoluteName, Consumer<T> InitializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent(); //acessa o primeiro elemento do MainView, faz o cast para ScrollPane, pega o valor de seu children e faz o quest novamente para VBox
			
			Node mainMenu = mainVBox.getChildren().get(0); //pega o primeiro elemento dos children do VBox
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			T controller = loader.getController();
			InitializingAction.accept(controller);
			
		}catch(IOException e) {
			Alerts.showAlert("IO Exception", "Error lodding view", e.getMessage(), AlertType.ERROR);
		}
	}	
}
