package siren.planners;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import siren.components.CarRequiredJobs;
import siren.components.ECarType;
import siren.components.Plan;
import siren.components.Shift;
import siren.components.Shifts;
import siren.jobs.Employee;
import siren.jobs.EmployeeService;
import siren.jobs.IJob;

public class SimplePlanner implements IPlannerAlgorithm {

	private Map<Shift, Set<Employee>> map;

	@Override
	public Plan plan(Shifts shifts, EmployeeService employeeService) {
		map = new HashMap<Shift, Set<Employee>>();
		for (int i = 1; i <= shifts.getDaysInMonth(); i++) {
			Set<Shift> dailyShifts = shifts.getShiftsForDay(i);
			for (Shift s : dailyShifts) {
				ECarType carType = s.getCarType();
				Set<IJob> jobs = CarRequiredJobs.get(carType);
				for (IJob job : jobs) {
					Employee e = findNext(job, employeeService);
					add(s, e);
				}
			}
		}
		Plan plan = new Plan(map);
		return plan;
	}

	private void add(Shift s, Employee e) {
		Set<Employee> employees = map.get(s);
		if (employees == null) {
			employees = new HashSet<Employee>();
			employees.add(e);
			map.put(s, employees);
		} else {
			employees.add(e);
		}
		
	}

	private Employee findNext(IJob job, EmployeeService employeeService) {
		return employeeService.findNext(job);
	}

}
