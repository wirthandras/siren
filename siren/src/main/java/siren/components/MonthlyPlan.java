package siren.components;

import java.time.LocalDate;
import java.util.List;

import siren.jobs.EmployeeService;
import siren.planners.IPlannerAlgorithm;

public class MonthlyPlan {

	private Shifts shifts;
	private EmployeeService employeeService;

	private Plan plan;

	public MonthlyPlan(final LocalDate date, EmployeeService employeeService, final List<Shift> shifts) {
		boolean leapYear = date.isLeapYear();
		int daysInMonth = date.getMonth().length(leapYear);

		this.employeeService = employeeService;
		this.shifts = new Shifts(daysInMonth, shifts);
	}

	public Plan doPlan(IPlannerAlgorithm algorithm) {
		this.plan = algorithm.plan(shifts, employeeService);
		return plan;
	}

	public Plan getPlan() {
		return plan;
	}

}
