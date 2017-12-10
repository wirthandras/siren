package siren.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Shifts {

	private int daysInMonth;

	private Map<Integer, Set<Shift>> shiftsInMonth;

	public Shifts(int daysInMonth) {
		this.shiftsInMonth = new HashMap<Integer, Set<Shift>>();
		this.daysInMonth = daysInMonth;
	}

	public void addShifts(List<Shift> shifts) {
		for (Shift s : shifts) {
			addShift(s);
		}
	}

	private void addShift(Shift shift) {
		int day = shift.getDay();
		Set<Shift> dayShifts = shiftsInMonth.get(day);
		if (dayShifts != null) {
			dayShifts.add(shift);
		} else {
			dayShifts = new HashSet<Shift>();
			dayShifts.add(shift);
			shiftsInMonth.put(day, dayShifts);
		}
	}

	@Override
	public String toString() {
		List<Shift> list = getShiftsAsList();
		return Arrays.toString(list.toArray());
	}

	public int getDaysInMonth() {
		return daysInMonth;
	}

	private List<Shift> getShiftsAsList() {
		List<Shift> list = new ArrayList<Shift>();
		for (Set<Shift> day : shiftsInMonth.values()) {
			list.addAll(day);
		}
		Collections.sort(list);
		return list;
	}

	public Shift getAdjacentAfter(Shift actShift) {
		List<Shift> shifts = getShiftsAsList();

		List<Shift> toRemove = new ArrayList<Shift>();
		for (Shift s : shifts) {
			if (s.compareTo(actShift) < 0) {
				toRemove.add(s);
			}
		}
		for (Shift s : toRemove) {
			shifts.remove(s);
		}
		shifts.remove(actShift);

		for (Shift s : shifts) {
			if (isNextSubscentShift(actShift, s)) {
				return s;
			}
		}
		return null;
	}

	private boolean isNextSubscentShift(Shift actShift, Shift shift) {
		if (actShift.getDay() == shift.getDay()) {
			return shift.getFrom() == actShift.getTo();
		} else {
			return actShift.getDay() + 1 == shift.getDay() && actShift.getTo() == shift.getFrom();
		}
	}
}
