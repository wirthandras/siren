package siren.jobs;

import org.junit.Assert;
import org.junit.Test;

public class ParamedicTest {
	
	@Test
	public void testParamedicNightWorking_ShouldBeTrue() {
		Paramedic paramedic = new Paramedic();
		
		Assert.assertTrue(paramedic.isNightWorking());
	}

}
