package siren.jobs;

import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {

	private String name = "TestName";
	private IJob job = JobFactory.doctor;
	private boolean is24hService = true;

	@Test
	public void testEmployeeName() {
		Employee e = new Employee(name, job, is24hService);

		Assert.assertNotNull(e);
		Assert.assertNotNull(e.getName());
		Assert.assertEquals(name, e.getName());
		Assert.assertEquals(job, e.getJob());
		Assert.assertTrue(e.isIs24hService());
	}

}
