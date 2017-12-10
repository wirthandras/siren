package siren.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ShiftsTest {

	private int daysInMonth = 2;
	private List<Shift> shiftsList;

	@Before
	public void setup() {
		shiftsList = ShiftsFactory.createShifts(daysInMonth);
	}

	@Test
	public void test30DayMonth() {
		Shifts shifts = new Shifts(30);

		assertEquals(30, shifts.getDaysInMonth());
	}

	@Test
	public void testToString() {
		Shifts shifts = new Shifts(1);
		shifts.addShifts(ShiftsFactory.createShifts(1));
		assertEquals("[{1:6-18}, {1:7-15}, {1:7-19}, {1:8-20}, {1:18-6}, {1:19-7}]", shifts.toString());
	}

	@Test
	public void testGetAdjacentAfter() {
		Shifts shifts = new Shifts(daysInMonth);
		shifts.addShifts(shiftsList);
		Shift shift = shiftsList.get(1);
		Shift adjecentShift = shifts.getAdjacentAfter(shift);
		assertEquals(shiftsList.get(4), adjecentShift);
	}

	@Test
	public void testGetAdjacentAfterOnNextDay() {
		Shifts shifts = new Shifts(daysInMonth);
		shifts.addShifts(shiftsList);
		Shift shift = shiftsList.get(3);
		Shift adjecentShift = shifts.getAdjacentAfter(shift);
		assertEquals(shiftsList.get(6), adjecentShift);
	}

	@Test
	public void testGetAdjacentAfterWithLastShift_ShouldBeNull() {
		Shifts shifts = new Shifts(daysInMonth);
		shifts.addShifts(shiftsList);
		Shift shift = shiftsList.get(shiftsList.size() - 1);
		Shift adjecentShift = shifts.getAdjacentAfter(shift);
		assertNull(adjecentShift);
	}
	
	@Test
	public void testGetAdjacentAfterNextDay_ShouldBeNull() {
		Shifts shifts = new Shifts(daysInMonth);
		Shift shift = new Shift(3, 18, 6);
		List<Shift> shiftsList = new ArrayList<Shift>();		
		shiftsList.add(new Shift(4, 7, 12));
		shifts.addShifts(shiftsList);
		Shift adjecentShift = shifts.getAdjacentAfter(shift);
		assertNull(adjecentShift);
	}
	
	@Test
	public void testGetAdjacentAfterSameDay_ShouldBeNull() {
		Shifts shifts = new Shifts(daysInMonth);
		Shift shift = new Shift(3, 6, 18);
		List<Shift> shiftsList = new ArrayList<Shift>();		
		shiftsList.add(new Shift(5, 17, 6));
		shifts.addShifts(shiftsList);
		Shift adjecentShift = shifts.getAdjacentAfter(shift);
		assertNull(adjecentShift);
	}
	
}
