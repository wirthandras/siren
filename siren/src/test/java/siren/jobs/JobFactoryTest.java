package siren.jobs;

import org.junit.Assert;
import org.junit.Test;

public class JobFactoryTest {

	@Test
	public void testParamedic() {
		
		IJob job = JobFactory.getJob("PARAMEDIC");
		
		Assert.assertEquals(JobFactory.paramedic, job);
	}
	
	@Test
	public void testNurse() {
		
		IJob job = JobFactory.getJob("NURSE");
		
		Assert.assertEquals(JobFactory.nurse, job);
	}
	
	@Test
	public void testMajorNurse() {
		
		IJob job = JobFactory.getJob("MAJOR_NURSE");
		
		Assert.assertEquals(JobFactory.majorNurse, job);
	}
	
	@Test
	public void testDoctor() {
		
		IJob job = JobFactory.getJob("DOCTOR");
		
		Assert.assertEquals(JobFactory.doctor, job);
	}
	
	@Test
	public void testDriver() {
		
		IJob job = JobFactory.getJob("DRIVER");
		
		Assert.assertEquals(JobFactory.driver, job);
	}
}
