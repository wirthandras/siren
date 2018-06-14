package siren.app.gui.employees;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import siren.app.Model;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		model = Model.getInstance();

		dropDownJobs.getItems().addAll(JobFactory.jobs);

	}

	public void add() {
		String name = inputName.getText();
		boolean is24hService = cb24h.isSelected();
		IJob job = dropDownJobs.getSelectionModel().getSelectedItem();
		Employee employee = new Employee(name, job, is24hService);
		model.getEmployeeService().add(employee);
	}

}
