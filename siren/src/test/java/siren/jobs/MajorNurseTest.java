package siren.jobs;

import org.junit.Assert;
import org.junit.Test;

public class MajorNurseTest {

	@Test
	public void testNurseNightWorkingShouldBeTrue() {
		MajorNurse n = new MajorNurse();

		Assert.assertTrue(n.isNightWorking());
	}
	
}
