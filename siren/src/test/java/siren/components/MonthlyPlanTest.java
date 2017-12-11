package siren.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import siren.jobs.Employee;
import siren.planners.IPlannerAlgorithm;

public class MonthlyPlanTest {

	@Mock
	private List<Employee> employees = new ArrayList<Employee>();
	@Mock
	private List<Shift> shiftsList = new ArrayList<Shift>();
	
	private LocalDate date;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(employees);
		MockitoAnnotations.initMocks(shiftsList);

		date = LocalDate.of(2017, Month.JANUARY, 1);
	}

	@Test
	@Ignore
	public void test() {
		MonthlyPlan mp = new MonthlyPlan(date, employees, shiftsList);

		IPlannerAlgorithm planner = Mockito.mock(IPlannerAlgorithm.class);

		Plan p = Mockito.mock(Plan.class);
		
		Mockito.when(planner.plan(Mockito.mock(Shifts.class), employees)).thenReturn(p);

		mp.doPlan(planner);

		assertNotNull(mp.getPlan());
		assertEquals(p, mp.getPlan());
	}

}
