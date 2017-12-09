package siren.components;

import java.util.ArrayList;
import java.util.List;

public class ShiftsFactory {

	public static List<Shift> createShifts(int daysInMonth) {
		List<Shift> shifts = new ArrayList<>();
		for (int i = 1; i <= daysInMonth; i++) {

			Shift m1 = new Shift(i, 6, 18);
			shifts.add(m1);
			Shift m2 = new Shift(i, 7, 19);
			shifts.add(m2);
			Shift m3 = new Shift(i, 8, 20);
			shifts.add(m3);
			Shift m4 = new Shift(i, 18, 6);
			shifts.add(m4);
			Shift m5 = new Shift(i, 19, 7);
			shifts.add(m5);
			Shift m6 = new Shift(i, 7, 15);
			shifts.add(m6);
		}
		return shifts;
	}

}
