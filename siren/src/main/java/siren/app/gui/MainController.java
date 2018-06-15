package siren.app.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;

public class MainController implements Initializable {
	
	private final String root = "Root";

	private final String empName = "Employees";
	private final String empPath = "/siren/app/gui/employees/EmployeeManagement.fxml";
	
	private final String carName = "Cars";
	private final String carPath = "/siren/app/gui/cars/CarManagement.fxml";
	
	private final String shiftsName = "Shifts";
	private final String shiftsPath = "/siren/app/gui/shifts/ShiftsManagement.fxml";

	@FXML
	private TreeView<String> treeView;
	@FXML
	private Pane subPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TreeItem<String> rootItem = new TreeItem<String>(root);

		SirenTreeItem itemEmployees = new SirenTreeItem(empName, empPath);
		rootItem.getChildren().add(itemEmployees);

		SirenTreeItem itemCars = new SirenTreeItem(carName, carPath);
		rootItem.getChildren().add(itemCars);
		
		SirenTreeItem itemShifts = new SirenTreeItem(shiftsName, shiftsPath);
		rootItem.getChildren().add(itemShifts);

		treeView.setRoot(rootItem);
		treeView.setShowRoot(false);
		rootItem.setExpanded(true);

		treeView.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> resetLayout(newValue));
	}

	private void resetLayout(TreeItem<String> item) {
		subPane.getChildren().clear();
		subPane.getChildren().add(((SirenTreeItem) item).getPane());
	}

}
