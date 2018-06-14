package siren.app.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;

public class MainController implements Initializable {

	@FXML
	private TreeView<String> treeView;
	@FXML
	private Pane subPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TreeItem<String> rootItem = new TreeItem<String>("Root");

		SirenTreeItem itemEmployees = new SirenTreeItem("Employees",
				"/siren/app/gui/employees/EmployeeManagement.fxml");
		rootItem.getChildren().add(itemEmployees);

		SirenTreeItem itemCars = new SirenTreeItem("Cars", "/siren/app/gui/cars/CarManagement.fxml");
		rootItem.getChildren().add(itemCars);

		treeView.setRoot(rootItem);
		treeView.setShowRoot(false);
		rootItem.setExpanded(true);

		treeView.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> resetLayout(newValue));
	}

	private void resetLayout(TreeItem<String> item) {
		subPane.getChildren().clear();
		subPane.getChildren().add(((SirenTreeItem)item).getPane());
	}

}
