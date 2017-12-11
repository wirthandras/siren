package siren.planners;

import java.util.List;

import siren.components.Plan;
import siren.components.Shifts;
import siren.jobs.Employee;

public interface IPlannerAlgorithm {

	public Plan plan(Shifts shifts, List<Employee> employees);
}
