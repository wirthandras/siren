package siren.components;

import java.time.LocalDate;
import java.util.List;

import siren.jobs.Employee;
import siren.planners.IPlannerAlgorithm;

public class MonthlyPlan {

	private Shifts shifts;
	private List<Employee> employees;

	private Plan plan;

	public MonthlyPlan(final LocalDate date, final List<Employee> employees, final List<Shift> shifts) {
		boolean leapYear = date.isLeapYear();
		int daysInMonth = date.getMonth().length(leapYear);

		this.employees = employees;
		this.shifts = new Shifts(daysInMonth, shifts);
	}

	public void doPlan(IPlannerAlgorithm algorithm) {
		this.plan = algorithm.plan(shifts, employees);
	}

	public Plan getPlan() {
		return plan;
	}

}
