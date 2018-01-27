package siren.components;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import siren.jobs.EmployeeService;
import siren.planners.SimplePlanner;

public class MonthlyPlanTest {

	@Test (expected = NullPointerException.class)
	public void testShiftsIsNull() {
		
		LocalDate date = LocalDate.of(2000, 3, 2);
		EmployeeService employeeService = Mockito.mock(EmployeeService.class);
		
		new MonthlyPlan(date, employeeService, null);
	}
	
	@Test
	public void testShifts() {
		
		LocalDate date = LocalDate.of(2000, 3, 2);
		EmployeeService employeeService = Mockito.mock(EmployeeService.class);
		
		 List<Shift> shifts = new ArrayList<Shift>();
		 shifts.add(new Shift(2, 3, 3, 16, ECarType.ESETKOCSI));
		 shifts.add(new Shift(5, 4, 5, 11, ECarType.ESETKOCSI));
		
		 MonthlyPlan plan = new MonthlyPlan(date, employeeService, shifts);
		 
		 Plan p = plan.doPlan(new SimplePlanner());
		 
		 Assert.assertNotNull(p);
	}
}
