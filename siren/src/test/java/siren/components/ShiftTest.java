package siren.components;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ShiftTest {

	@Test
	public void testShiftIsNight_ShouldBeFalse() {
		Shift shift = new Shift(Mockito.anyInt(), Mockito.anyInt(), 8, 18, Mockito.any(ECarType.class));
		Assert.assertFalse(shift.isNight());
	}

	@Test
	public void testShiftIsNight_ShouldBeTrue() {
		Shift shift = new Shift(Mockito.anyInt(), Mockito.anyInt(), 18, 6, Mockito.any(ECarType.class));
		Assert.assertTrue(shift.isNight());
	}

	@Test
	public void testShiftDuration_ShouldBe12Hour() {
		Shift shift = new Shift(Mockito.anyInt(), Mockito.anyInt(), 18, 6, Mockito.any(ECarType.class));
		Assert.assertEquals(12, shift.duration());
	}

	@Test
	public void testShiftIsNight_ShouldBe7Hour() {
		Shift shift = new Shift(Mockito.anyInt(), Mockito.anyInt(), 8, 15, Mockito.any(ECarType.class));
		Assert.assertEquals(7, shift.duration());
	}

	@Test
	public void testShiftGetDay_ShouldBe15() {
		Shift shift = new Shift(15, Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.any(ECarType.class));
		Assert.assertEquals(15, shift.getDay());
	}
	
	@Test
	public void testGetCarType_ShouldBeRohamkocsi() {
		Shift shift = new Shift(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), ECarType.ROHAMKOCSI);
		Assert.assertEquals(ECarType.ROHAMKOCSI, shift.getCarType());
	}

}
