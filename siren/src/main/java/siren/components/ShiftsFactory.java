package siren.components;

import java.util.ArrayList;
import java.util.List;

public class ShiftsFactory {

	public static List<Shift> createShifts(int daysInMonth) {
		List<Shift> shifts = new ArrayList<Shift>();
		for (int i = 1; i <= daysInMonth; i++) {
			
			int id = 1;

			Shift m1 = new Shift(i, id++, 6, 18, ECarType.ESETKOCSI);
			shifts.add(m1);
			Shift m2 = new Shift(i, id ++, 7, 19, ECarType.ESETKOCSI);
			shifts.add(m2);
			Shift m3 = new Shift(i, id++, 8, 20, ECarType.ESETKOCSI);
			shifts.add(m3);
			Shift m4 = new Shift(i, id++, 18, 6, ECarType.ESETKOCSI);
			shifts.add(m4);
			Shift m5 = new Shift(i, id++, 19, 7, ECarType.ESETKOCSI);
			shifts.add(m5);
			Shift m6 = new Shift(i, id++, 7, 15, ECarType.ESETKOCSI);
			shifts.add(m6);
		}
		return shifts;
	}

}
