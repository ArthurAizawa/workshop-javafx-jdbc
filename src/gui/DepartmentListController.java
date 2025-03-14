package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {

	private DepartmentService service;

	@FXML
	private TableView<Department> tableViewDepartment;

	@FXML
	private TableColumn<Department, Integer> tableColumnId;

	@FXML
	private TableColumn<Department, String> tableColumnName;

	@FXML
	private Button btNew;

	private ObservableList<Department> obsList;

	@FXML
	private void OnBtNewAction() {
		System.out.println("OnBtNewAction");
	}

	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Método initialize() foi chamado.");
		if (tableViewDepartment == null) {
			System.out.println("Erro: tableViewDepartment ainda está NULL no initialize()!");
		} else {
			System.out.println("tableViewDepartment foi carregado corretamente.");
		}
		initializeNodes();
	}

	private void initializeNodes() {
		if (tableViewDepartment == null) {
			System.out.println("Erro crítico: tableViewDepartment ainda está NULL! Criando manualmente...");
			tableViewDepartment = new TableView<>();
		}

		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
	}

	public void updateTableView() {
		System.out.println("updateTableView() is true");

		if (tableViewDepartment == null) {
			System.out.println("ERROR! tableVIewDepartment() a not response");
		}

		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Department> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartment.setItems(obsList);
	}
}
