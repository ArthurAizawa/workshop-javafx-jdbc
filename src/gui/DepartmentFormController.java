package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable {
	@FXML
	private TextField txtName;

	@FXML
	private TextField txtId;

	@FXML
	private Label errorName;

	@FXML
	private Label errorId;

	@FXML
	private Button btnSave;

	@FXML
	private Button btnCancel;
	
	public void OnActionBtnSave() {
		System.out.println("Save");
	}

	@FXML
	public void OnActionCancel() {
		System.out.println("Cancel");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeNode();

	}

	private void initializeNode() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}

}
