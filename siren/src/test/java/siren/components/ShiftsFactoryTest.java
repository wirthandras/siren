package siren.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

public class ShiftsFactoryTest {

	@Test
	public void testFactory() {
		List<Shift> shifts = ShiftsFactory.createShifts(2);
		
		assertNotNull(shifts);
		assertEquals(12, shifts.size());
	}
	
	@Test
	public void testCobstructor() {
		ShiftsFactory factory = new ShiftsFactory();
		
		assertNotNull(factory);
	}
}
