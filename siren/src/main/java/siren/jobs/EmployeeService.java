package siren.jobs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeService {

	private List<Employee> employees;

	public EmployeeService(List<Employee> employees) {
		super();
		this.employees = employees;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public Employee findNext(IJob job) {
		if (employees != null) {
			List<Employee> filteredEmployees = new ArrayList<Employee>(filter(job));
			//TODO improve
			return filteredEmployees.get(0);
		} else {
			return null;
		}
	}

	public Set<Employee> filter(IJob job) {
		Set<Employee> filteredEmployees = new HashSet<Employee>();
		if (employees != null) {
			for (Employee e : employees) {
				if (e.getJob().equals(job)) {
					filteredEmployees.add(e);
				}
			}
		}
		return filteredEmployees;
	}

}
