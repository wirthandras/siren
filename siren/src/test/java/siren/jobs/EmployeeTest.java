package siren.jobs;

import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {
	
	private String name = "TestName";
	
	@Test
	public void testEmployeeName() {
		Employee e = new Employee(name);
		
		Assert.assertNotNull(e);
		Assert.assertNotNull(e.getName());
		Assert.assertEquals(name, e.getName());
	}

}
