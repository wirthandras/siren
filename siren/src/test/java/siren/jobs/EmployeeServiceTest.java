package siren.jobs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class EmployeeServiceTest {

	private List<Employee> employees;

	@Before
	public void setUp() {
		employees = new ArrayList<Employee>();
		employees.add(new Employee("testDoctor1", JobFactory.doctor, true));
		employees.add(new Employee("testDoctor2", JobFactory.doctor, false));
		employees.add(new Employee("testDriver1", JobFactory.driver, true));
		employees.add(new Employee("testDriver2", JobFactory.driver, false));
		employees.add(new Employee("testDriver3", JobFactory.driver, true));
		employees.add(new Employee("testNurse1", JobFactory.nurse, true));
		employees.add(new Employee("testNurse1", JobFactory.nurse, true));
		employees.add(new Employee("testNurse2", JobFactory.nurse, false));
		employees.add(new Employee("testNurse3", JobFactory.nurse, false));
		employees.add(new Employee("testNurse4", JobFactory.nurse, true));
	}

	@Test
	public void testGetEmployeesOnNullEmployees() {
		EmployeeService empService = new EmployeeService(null);

		assertNull(empService.getEmployees());
	}

	@Test
	public void testFiterOnNullEmployees() {
		EmployeeService empService = new EmployeeService(null);

		assertNotNull(empService.filter(JobFactory.nurse));
		assertEquals(0, empService.filter(JobFactory.nurse).size());
	}

	@Test
	public void testFindNextOnNullEmployees() {
		EmployeeService empService = new EmployeeService(null);

		assertNull(empService.findNext(JobFactory.nurse));
	}

	@Test
	public void testFindNextOnTestEmployees() {
		EmployeeService empService = new EmployeeService(employees);

		assertNotNull(empService.findNext(JobFactory.nurse));
	}

	@Test
	public void testFilterNurseOnTestEmployees() {
		EmployeeService empService = new EmployeeService(employees);

		assertNotNull(empService.filter(JobFactory.nurse));
		assertEquals(5, empService.filter(JobFactory.nurse).size());
	}
}
