package siren.jobs;

import org.junit.Assert;

public class DriverTest {

	public void testDriverNightWorking_ShouldBeTrue() {
		Driver driver = new Driver();

		Assert.assertTrue(driver.isNightWorking());
	}

}
