package siren.jobs;

import org.junit.Assert;
import org.junit.Test;

public class JobFactoryTest {
	
	@Test
	public void testConstructor() {
		JobFactory factory = new JobFactory();
		Assert.assertNotNull(factory);
	}

	@Test
	public void testParamedic() {
		IJob job = JobFactory.getJob("PARAMEDIC");
		Assert.assertNotNull(job);
		Assert.assertEquals(JobFactory.paramedic, job);
	}
	
	@Test
	public void testNurse() {
		IJob job = JobFactory.getJob("NURSE");
		Assert.assertNotNull(job);
		Assert.assertEquals(JobFactory.nurse, job);
	}
	
	@Test
	public void testMajorNurse() {
		IJob job = JobFactory.getJob("MAJOR_NURSE");
		Assert.assertNotNull(job);
		Assert.assertEquals(JobFactory.majorNurse, job);
	}
	
	@Test
	public void testDoctor() {
		IJob job = JobFactory.getJob("DOCTOR");
		Assert.assertNotNull(job);
		Assert.assertEquals(JobFactory.doctor, job);
	}
	
	@Test
	public void testDriver() {
		IJob job = JobFactory.getJob("DRIVER");
		Assert.assertNotNull(job);
		Assert.assertEquals(JobFactory.driver, job);
	}
	
	@Test
	public void testInvalidJob() {
		IJob job = JobFactory.getJob("INVALID_JOB");
		Assert.assertNull(job);
	}
	
	@Test
	public void testNull() {
		IJob job = JobFactory.getJob(null);
		Assert.assertNull(job);
	}
}
