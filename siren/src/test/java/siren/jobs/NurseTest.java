package siren.jobs;

import org.junit.Assert;
import org.junit.Test;

public class NurseTest {

	@Test
	public void testNurseNightWorking_ShouldBeFalse() {
		Nurse n = new Nurse();

		Assert.assertFalse(n.isNightWorking());
	}
}
