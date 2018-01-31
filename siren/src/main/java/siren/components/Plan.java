package siren.components;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import siren.jobs.Employee;

public class Plan {

	private int daysInMonth;
	private Map<Shift, Set<Employee>> plan;

	public Plan(int daysInMonth, Map<Shift, Set<Employee>> plan) {
		this.plan = plan;
		this.daysInMonth = daysInMonth;
	}

	public Map<Shift, Set<Employee>> getPlan() {
		return plan;
	}

	public int getDays() {
		return daysInMonth;
	}

	public int sumWorkingHours(Employee employee) {
		int sum = 0;
		for (Shift s : plan.keySet()) {
			if (plan.get(s).contains(employee)) {
				sum += s.duration();
			}
		}
		return sum;
	}

	public boolean isNormalShiftDay(Employee employee, int day) {
		for (Shift shift : filterByDay(day)) {
			// TODO only hits the first shift in a day, ordering not ensured
			return shift.getCarType() != null;
		}
		// may throw an exception
		return false;
	}

	public int getTime(Employee employee, int actDay, boolean start) {
		for (Shift shift : filterByDay(actDay)) {
			if (plan.get(shift).contains(employee)) {
				if (start) {
					return shift.getFrom();
				} else {
					return shift.getTo();
				}
			}
		}
		return -1;
	}

	public Set<Shift> filterByDay(int day) {
		Set<Shift> set = new HashSet<Shift>();
		for (Shift shift : plan.keySet()) {
			if (shift.getDay() == day) {
				set.add(shift);
			}
		}
		return set;
	}

}
