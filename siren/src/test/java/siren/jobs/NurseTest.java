package siren.jobs;

import org.junit.Assert;
import org.junit.Test;

public class NurseTest {

	@Test
	public void testNurseNightWorkingShouldBeFalse() {
		Nurse n = new Nurse();

		Assert.assertFalse(n.isNightWorking());
	}
}
