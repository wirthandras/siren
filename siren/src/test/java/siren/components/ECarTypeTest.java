package siren.components;

import org.junit.Assert;
import org.junit.Test;

public class ECarTypeTest {

	@Test
	public void testEsetKocsi() {
		ECarType t = ECarType.ESETKOCSI;
		Assert.assertEquals("Esetkocsi", t.toString());
	}

	@Test
	public void testRohamkocsi() {
		ECarType t = ECarType.ROHAMKOCSI;
		Assert.assertEquals("Rohamkocsi", t.toString());
	}
	
	@Test
	public void testRandom() {
		ECarType t = ECarType.random();
		Assert.assertTrue(t instanceof ECarType);
	}
}
