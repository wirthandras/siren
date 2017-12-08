package siren.jobs;

import org.junit.Assert;
import org.junit.Test;

public class DoctorTest  {

	@Test
	public void testDoctorNightWorking_ShouldBeTrue() {
		Doctor doctor = new Doctor();
		
		Assert.assertTrue(doctor.isNightWorking());
	}

}
