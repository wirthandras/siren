package siren.components;

import java.util.Map;
import java.util.Set;

import siren.jobs.Employee;

public class Plan {

	private Map<Shift, Set<Employee>> plan;

	public Plan(Map<Shift, Set<Employee>> plan) {
		this.plan = plan;
	}

	public Map<Shift, Set<Employee>> getPlan() {
		return plan;
	}

}
