package siren.jobs;

import org.junit.Assert;
import org.junit.Test;

public class ParamedicTest {
	
	@Test
	public void testParamedicNightWorkingShouldBeTrue() {
		Paramedic paramedic = new Paramedic();
		
		Assert.assertTrue(paramedic.isNightWorking());
	}

}
