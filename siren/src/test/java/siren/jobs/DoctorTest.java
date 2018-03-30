package siren.jobs;

import org.junit.Assert;
import org.junit.Test;

public class DoctorTest  {

	@Test
	public void testDoctorNightWorkingShouldBeTrue() {
		Doctor doctor = new Doctor();
		
		Assert.assertTrue(doctor.isNightWorking());
	}

}
