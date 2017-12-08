package siren.jobs;

import org.junit.Assert;

public class ParamedicTest {
	
	public void testParamedicNightWorking_ShouldBeTrue() {
		Paramedic paramedic = new Paramedic();
		
		Assert.assertTrue(paramedic.isNightWorking());
	}

}
