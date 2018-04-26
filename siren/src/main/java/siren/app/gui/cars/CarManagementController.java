package siren.app.gui.cars;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import siren.app.Model;
import siren.app.TextIds;
import siren.components.Car;
import siren.components.ECarType;

public class CarManagementController implements Initializable {

	private Model model;

	@FXML
	public TextField carIdentifier;
	@FXML
	public ChoiceBox<ECarType> carType;
	@FXML
	public TableView<Car> tableView;
	@FXML
	public Button buttonDelete;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		model = Model.getInstance();
		carType.getItems().addAll(ECarType.values());

		// Create column UserName (Data type of String).
		TableColumn<Car, String> columnIdentifier = new TableColumn<Car, String>(
				resources.getString(TextIds.IDENTIFIER));
		TableColumn<Car, String> columnType = new TableColumn<Car, String>(resources.getString(TextIds.TYPE));

		columnIdentifier.setCellValueFactory(new PropertyValueFactory<>("identifier"));
		columnType.setCellValueFactory(new PropertyValueFactory<>("type"));

		tableView.getColumns().add(columnIdentifier);
		tableView.getColumns().add(columnType);

		buttonDelete.setOnAction(e -> {
			Car selectedItem = tableView.getSelectionModel().getSelectedItem();
			tableView.getItems().remove(selectedItem);
		});

	}

	@FXML
	public void add() {
		String cid = carIdentifier.getText();
		if (idIsUnique(cid)) {
			ECarType type = carType.getSelectionModel().getSelectedItem();
			Car car = new Car(cid, type);
			model.addCar(car);

			tableView.getItems().clear();
			tableView.getItems().addAll(model.getCars());
		} else {
			// TODO feedback for user the given Identifier is already exist
		}
	}

	private boolean idIsUnique(String identifier) {
		return !model.identifierIsExist(identifier);
	}
}
