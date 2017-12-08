package siren.jobs;

import org.junit.Assert;
import org.junit.Test;

public class DriverTest {

	@Test
	public void testDriverNightWorking_ShouldBeTrue() {
		Driver driver = new Driver();

		Assert.assertTrue(driver.isNightWorking());
	}

}
