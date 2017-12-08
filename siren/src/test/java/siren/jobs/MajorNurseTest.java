package siren.jobs;

import org.junit.Assert;
import org.junit.Test;

public class MajorNurseTest {

	@Test
	public void testNurseNightWorking_ShouldBeTrue() {
		MajorNurse n = new MajorNurse();

		Assert.assertTrue(n.isNightWorking());
	}
	
}
