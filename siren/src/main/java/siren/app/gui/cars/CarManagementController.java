package siren.app.gui.cars;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import siren.app.Model;
import siren.components.Car;
import siren.components.ECarType;

public class CarManagementController implements Initializable {

	private Model model;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = Model.getInstance();
		carType.getItems().addAll(ECarType.values());

		// Create column UserName (Data type of String).
		TableColumn<Car, String> colIdentifier = new TableColumn<Car, String>("Rendszám");
		TableColumn<Car, String> colType = new TableColumn<Car, String>("Típus");

		colIdentifier.setCellValueFactory(new PropertyValueFactory<>("identifier"));
		colType.setCellValueFactory(new PropertyValueFactory<>("type"));

		tableView.getColumns().add(colIdentifier);
		tableView.getColumns().add(colType);

	}

	@FXML
	public TextField carIdentifier;
	@FXML
	public ChoiceBox<ECarType> carType;
	@FXML
	public TableView<Car> tableView;

	@FXML
	public void add() {
		String identifier = carIdentifier.getText();
		ECarType type = carType.getSelectionModel().getSelectedItem();
		Car car = new Car(identifier, type);
		model.addCar(car);
		
		tableView.getItems().clear();
		tableView.getItems().addAll(model.getCars());
	}
}
