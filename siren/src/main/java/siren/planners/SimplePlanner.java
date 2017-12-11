package siren.planners;

import java.util.List;
import java.util.Set;

import siren.components.ECarType;
import siren.components.Plan;
import siren.components.Shift;
import siren.components.Shifts;
import siren.jobs.Employee;

public class SimplePlanner implements IPlannerAlgorithm {

	@Override
	public Plan plan(Shifts shifts, List<Employee> employees) {
		for (int i = 1; i <= shifts.getDaysInMonth(); i++) {
			Set<Shift> dailyShifts = shifts.getShiftsForDay(i);
			for (Shift s : dailyShifts) {
				ECarType carType = s.getCarType();
				
				
				
			}
		}
		return new Plan(null);
	}

}
