package siren.outofoffice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import siren.jobs.Employee;

public class OutOfOfficeTest {

	private Employee employee;
	private OutOfOffice o;
	
	@Before
	public void setup() {
		employee = Mockito.mock(Employee.class);
		o = new OutOfOffice();
	}
	
	@Test
	public void testGetShouldBeNull() {
		Assert.assertNull(o.get(employee));
	}
	
	@Test
	public void testPutShouldBeNull() {
		o.put(employee, 1, EOutType.HOLIDAY);
		o.put(employee, 2, EOutType.SICK);
		o.put(employee, 3, EOutType.SICK);
		Assert.assertNotNull(o.get(employee));
		Assert.assertEquals(1, o.get(employee).getNumberOfHolidays());
		Assert.assertEquals(2, o.get(employee).getSicks().size());
	}
}
