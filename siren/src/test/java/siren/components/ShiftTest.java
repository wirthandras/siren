package siren.components;

import org.junit.Assert;
import org.junit.Test;

public class ShiftTest {

	@Test
	public void testShiftIsNight_ShouldBeFalse() {
		Shift shift = new Shift(0, 8, 18);
		Assert.assertFalse(shift.isNight());
	}

	@Test
	public void testShiftIsNight_ShouldBeTrue() {
		Shift shift = new Shift(0, 18, 6);
		Assert.assertTrue(shift.isNight());
	}

	@Test
	public void testShiftDuration_ShouldBe12Hour() {
		Shift shift = new Shift(0, 18, 6);
		Assert.assertEquals(12, shift.duration());
	}

	@Test
	public void testShiftIsNight_ShouldBe7Hour() {
		Shift shift = new Shift(0, 8, 15);
		Assert.assertEquals(7, shift.duration());
	}

	@Test
	public void testShiftGetDay_ShouldBe15() {
		Shift shift = new Shift(15, 8, 15);
		Assert.assertEquals(15, shift.getDay());
	}

}
