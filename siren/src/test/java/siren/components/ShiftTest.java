package siren.components;

import org.junit.Assert;
import org.junit.Test;

public class ShiftTest {

	private int day = 4;
	private int idOfshift = 3;
	private int testFrom = 8;
	private int testTo = 18;
	private ECarType carType = ECarType.ESETKOCSI;

	@Test
	public void testShiftIsNight_ShouldBeFalse() {
		Shift shift = new Shift(day, idOfshift, 8, 18, carType);
		Assert.assertFalse(shift.isNight());
	}

	@Test
	public void testShiftIsNight_ShouldBeTrue() {
		Shift shift = new Shift(day, idOfshift, 18, 6, carType);
		Assert.assertTrue(shift.isNight());
	}

	@Test
	public void testShiftDuration_ShouldBe12Hour() {
		Shift shift = new Shift(day, idOfshift, 18, 6, carType);
		Assert.assertEquals(12, shift.duration());
	}

	@Test
	public void testShiftIsNight_ShouldBe7Hour() {
		Shift shift = new Shift(day, idOfshift, 8, 15, carType);
		Assert.assertEquals(7, shift.duration());
	}

	@Test
	public void testShiftGetDay_ShouldBe15() {
		Shift shift = new Shift(15, idOfshift, testFrom, testTo, carType);
		Assert.assertEquals(15, shift.getDay());
	}

	@Test
	public void testGetCarType_ShouldBeRohamkocsi() {
		Shift shift = new Shift(day, idOfshift, testFrom, testTo, ECarType.ROHAMKOCSI);
		Assert.assertEquals(ECarType.ROHAMKOCSI, shift.getCarType());
	}

}
