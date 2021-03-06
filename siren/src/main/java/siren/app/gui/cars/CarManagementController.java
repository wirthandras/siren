package siren.app.gui.cars;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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

		String labelId = resources.getString(TextIds.IDENTIFIER);
		String labelType = resources.getString(TextIds.TYPE);
		String labelTableEmpty = resources.getString(TextIds.TABLE_EMPTY);

		TableColumn<Car, String> columnIdentifier = new TableColumn<Car, String>(labelId);
		TableColumn<Car, String> columnType = new TableColumn<Car, String>(labelType);

		columnIdentifier.setCellValueFactory(new PropertyValueFactory<>("identifier"));
		columnType.setCellValueFactory(new PropertyValueFactory<>("type"));

		tableView.getColumns().add(columnIdentifier);
		tableView.getColumns().add(columnType);
		tableView.setPlaceholder(new Label(labelTableEmpty));

		buttonDelete.setOnAction(e -> {
			Car selectedItem = tableView.getSelectionModel().getSelectedItem();
			tableView.getItems().remove(selectedItem);
		});
		
		//TODO remove from model

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
