package siren.jobs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeService {

	private List<Employee> employees;

	public EmployeeService() {
		super();
		this.employees = new ArrayList<Employee>();
	}

	public void addAll(List<Employee> employees) {
		this.employees.addAll(employees);
	}

	public void add(Employee employee) {
		this.employees.add(employee);
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public Employee findNext(IJob job) {
		List<Employee> filteredEmployees = new ArrayList<Employee>(filter(job));
		if (filteredEmployees.size() > 0) {
			return filteredEmployees.get(0);
		} else {
			return null;
		}
	}

	public Set<Employee> filter(IJob job) {
		Set<Employee> filteredEmployees = new HashSet<Employee>();
		for (Employee e : employees) {
			if (e.getJob().equals(job)) {
				filteredEmployees.add(e);
			}
		}
		return filteredEmployees;
	}

}
