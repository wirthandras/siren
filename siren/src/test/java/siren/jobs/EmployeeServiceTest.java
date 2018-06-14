package siren.jobs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EmployeeServiceTest {

	private EmployeeService employeeService;
	private List<Employee> employees;

	@Before
	public void setUp() {

		employeeService = new EmployeeService();

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
	public void testAddAnEmployee() {

		Employee testEmployee = Mockito.mock(Employee.class);

		assertNotNull(employeeService.getEmployees());
		assertEquals(0, employeeService.getEmployees().size());
		
		employeeService.add(testEmployee);
		
		assertNotNull(employeeService.getEmployees());
		assertEquals(1, employeeService.getEmployees().size());
		assertEquals(testEmployee, employeeService.getEmployees().get(0));
	}

	@Test
	public void testGetEmployeesOnNullEmployees() {
		assertNotNull(employeeService.getEmployees());
		assertEquals(0, employeeService.getEmployees().size());
	}

	@Test
	public void testFiterOnNullEmployees() {
		assertNotNull(employeeService.filter(JobFactory.nurse));
		assertEquals(0, employeeService.filter(JobFactory.nurse).size());
	}

	@Test
	public void testFindNextOnNullEmployees() {
		assertNull(employeeService.findNext(JobFactory.nurse));
	}

	@Test
	public void testFindNextOnTestEmployees() {
		employeeService.addAll(employees);

		assertNotNull(employeeService.findNext(JobFactory.nurse));
	}

	@Test
	public void testFilterNurseOnTestEmployees() {
		employeeService.addAll(employees);

		assertNotNull(employeeService.filter(JobFactory.nurse));
		assertEquals(5, employeeService.filter(JobFactory.nurse).size());
	}
}
