package siren.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.mockito.Mockito;

import siren.jobs.Employee;
import siren.jobs.JobFactory;

public class PlanTest {

	private final int daysInMonth = 31;
	private final int resultZero = 0;
	private final int resultTwelve = 12;

	@Test
	public void testGetPlan() {
		Map<Shift, Set<Employee>> m = new HashMap<Shift, Set<Employee>>();
		Plan plan = new Plan(daysInMonth, m);
		assertNotNull(plan.getPlan());
		assertEquals(m, plan.getPlan());
	}

	@Test
	public void testGetDays() {
		Plan plan = new Plan(daysInMonth, null);
		assertEquals(daysInMonth, plan.getDays());
	}

	@Test
	public void testSumWorkingHour() {
		Employee emp = new Employee("TestName", JobFactory.driver, false);
		Employee emp2 = new Employee("TestName2", JobFactory.driver, false);
		Map<Shift, Set<Employee>> m = new HashMap<Shift, Set<Employee>>();
		Shift shift = Mockito.mock(Shift.class);
		Mockito.when(shift.duration()).thenReturn(resultTwelve);
		Set<Employee> set = new HashSet<Employee>();
		set.add(emp);
		m.put(shift, set);
		Plan plan = new Plan(daysInMonth, m);
		assertEquals(resultTwelve, plan.sumWorkingHours(emp));
		assertEquals(resultZero, plan.sumWorkingHours(emp2));
	}

	@Test
	public void testIsNormalShiftDayWithZeroShift() {
		Employee emp = new Employee("TestName", JobFactory.driver, false);
		Map<Shift, Set<Employee>> m = new HashMap<Shift, Set<Employee>>();
		Plan plan = new Plan(daysInMonth, m);
		assertFalse(plan.isNormalShiftDay(emp, resultTwelve));
	}

	@Test
	public void testIsNormalShiftDay() {
		Employee emp = new Employee("TestName", JobFactory.driver, false);
		Map<Shift, Set<Employee>> m = new HashMap<Shift, Set<Employee>>();

		Shift shift = Mockito.mock(Shift.class);
		Mockito.when(shift.getDay()).thenReturn(resultTwelve);
		Mockito.when(shift.getCarType()).thenReturn(ECarType.ESETKOCSI);

		Shift shift2 = Mockito.mock(Shift.class);
		Mockito.when(shift2.getDay()).thenReturn(13);
		Mockito.when(shift2.getCarType()).thenReturn(ECarType.ESETKOCSI);

		Shift shift3 = Mockito.mock(Shift.class);
		Mockito.when(shift3.getDay()).thenReturn(14);
		Mockito.when(shift3.getCarType()).thenReturn(null);

		Set<Employee> set = new HashSet<Employee>();
		set.add(emp);
		Set<Employee> set2 = new HashSet<Employee>();

		m.put(shift, set);
		m.put(shift2, set2);
		m.put(shift3, set2);
		Plan plan = new Plan(daysInMonth, m);
		assertTrue(plan.isNormalShiftDay(emp, resultTwelve));
		assertTrue(plan.isNormalShiftDay(emp, 13));
		assertFalse(plan.isNormalShiftDay(emp, 14));
	}

	@Test
	public void testGetTime() {
		Employee emp = Mockito.mock(Employee.class);
		Set<Employee> set = new HashSet<Employee>();
		set.add(emp);

		Map<Shift, Set<Employee>> m = new HashMap<Shift, Set<Employee>>();

		Shift shift = Mockito.mock(Shift.class);
		Mockito.when(shift.getDay()).thenReturn(resultTwelve);
		Mockito.when(shift.getFrom()).thenReturn(8);
		Mockito.when(shift.getTo()).thenReturn(16);
		Mockito.when(shift.getCarType()).thenReturn(ECarType.ESETKOCSI);

		m.put(shift, set);
		Plan plan = new Plan(daysInMonth, m);
		assertEquals(8, plan.getTime(emp, resultTwelve, true));
		assertEquals(16, plan.getTime(emp, resultTwelve, false));
		assertEquals(-1, plan.getTime(emp, 10, false));
		Employee emp2 = Mockito.mock(Employee.class);
		assertEquals(-1, plan.getTime(emp2, resultTwelve, false));
	}

}