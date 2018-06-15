package siren.app.gui.employees;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import siren.app.Model;
import siren.app.TextIds;
import siren.jobs.Employee;
import siren.jobs.IJob;
import siren.jobs.JobFactory;

public class EmployeeManagementController implements Initializable {

	private Model model;

	@FXML
	private TextField inputName;
	@FXML
	private CheckBox cb24h;
	@FXML
	private ComboBox<IJob> dropDownJobs;
	@FXML
	private TableView<Employee> tableView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = Model.getInstance();

		dropDownJobs.getItems().addAll(JobFactory.jobs);

		// Create column UserName (Data type of String).
		String labelName = resources.getString(TextIds.EMP_NAME);
		String labelJob = resources.getString(TextIds.EMP_JOB);
		String labelIs24h = resources.getString(TextIds.EMP_24H);
		String labelTableEmpty = resources.getString(TextIds.TABLE_EMPTY);

		TableColumn<Employee, String> columnName = new TableColumn<Employee, String>(labelName);
		TableColumn<Employee, String> columnJob = new TableColumn<Employee, String>(labelJob);
		TableColumn<Employee, Boolean> column24 = new TableColumn<Employee, Boolean>(labelIs24h);

		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		columnJob.setCellValueFactory(new PropertyValueFactory<>("job"));
		column24.setCellValueFactory(new PropertyValueFactory<>("is24hService"));
		
		tableView.getColumns().clear();
		tableView.getColumns().add(columnName);
		tableView.getColumns().add(columnJob);
		tableView.getColumns().add(column24);
		tableView.setPlaceholder(new Label(labelTableEmpty));
	}

	public void add() {
		String name = inputName.getText();
		boolean is24hService = cb24h.isSelected();
		IJob job = dropDownJobs.getSelectionModel().getSelectedItem();
		Employee employee = new Employee(name, job, is24hService);
		model.getEmployeeService().add(employee);

		tableView.getItems().clear();
		tableView.getItems().addAll(model.getEmployeeService().getEmployees());
	}

}
