package siren.planners;

import siren.components.Plan;
import siren.components.Shifts;
import siren.jobs.EmployeeService;

public interface IPlannerAlgorithm {

	public Plan plan(Shifts shifts, EmployeeService employeeService);
}
