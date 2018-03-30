package siren.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ShiftsTest {

	private final int daysInMonth = 2;
	private List<Shift> shiftsList;
	private final String testStringOutput = "[{1/1:6-18}, {1/6:7-15}, {1/2:7-19}, {1/3:8-20}, {1/4:18-6}, {1/5:19-7}]";

	private ECarType carType;
	
	@Before
	public void setUp() {
		shiftsList = ShiftsFactory.createShifts(daysInMonth);
		carType = ECarType.ESETKOCSI;
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
		assertEquals(testStringOutput, shifts.toString());
	}
	
	@Test
	public void testToString2() {
		Shifts shifts = new Shifts(1, ShiftsFactory.createShifts(1));
		assertEquals(testStringOutput, shifts.toString());
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
	public void testGetAdjacentAfterWithLastShiftShouldBeNull() {
		Shifts shifts = new Shifts(daysInMonth);
		shifts.addShifts(shiftsList);
		Shift shift = shiftsList.get(shiftsList.size() - 1);
		Shift adjecentShift = shifts.getAdjacentAfter(shift);
		assertNull(adjecentShift);
	}
	
	@Test
	public void testGetAdjacentAfterNextDayShouldBeNull() {
		Shifts shifts = new Shifts(daysInMonth);
		Shift shift = new Shift(3, 3, 18, 6, carType);
		List<Shift> shiftsList = new ArrayList<Shift>();		
		shiftsList.add(new Shift(4, 3, 7, 12, carType));
		shifts.addShifts(shiftsList);
		Shift adjecentShift = shifts.getAdjacentAfter(shift);
		assertNull(adjecentShift);
	}
	
	@Test
	public void testGetAdjacentAfterSameDayShouldBeNull() {
		Shifts shifts = new Shifts(daysInMonth);
		Shift shift = new Shift(3, 3, 6, 18, carType);
		List<Shift> shiftsList = new ArrayList<Shift>();		
		shiftsList.add(new Shift(5, 6, 17, 6, carType));
		shifts.addShifts(shiftsList);
		Shift adjecentShift = shifts.getAdjacentAfter(shift);
		assertNull(adjecentShift);
	}
	
	@Test
	public void testGetShiftsForDayShouldBeTwoShiftOnTestDay() {
		int dayToTest = 5;
		
		Shifts shifts = new Shifts(daysInMonth);
		List<Shift> shiftsList = new ArrayList<Shift>();		
		shiftsList.add(new Shift(dayToTest, 6, 17, 6, carType));
		shiftsList.add(new Shift(dayToTest, 4, 10, 18, carType));
		shifts.addShifts(shiftsList);
		Set<Shift> shiftsAtday = shifts.getShiftsForDay(dayToTest);
		assertNotNull(shiftsAtday);
		assertEquals(2, shiftsAtday.size());
	}
	
	@Test
	public void testGetShiftsForDayShouldBeNullOnTestDay() {
		int dayToTest = 5;
		
		Shifts shifts = new Shifts(daysInMonth);
		List<Shift> shiftsList = new ArrayList<Shift>();
		shifts.addShifts(shiftsList);
		Set<Shift> shiftsAtday = shifts.getShiftsForDay(dayToTest);
		assertNull(shiftsAtday);
	}
	
}
