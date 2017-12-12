package siren.planners;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.mockito.Mockito;

import siren.components.ECarType;
import siren.components.Plan;
import siren.components.Shift;
import siren.components.Shifts;
import siren.jobs.EmployeeService;
import siren.jobs.IJob;

public class SimplePlannerTest {

	@Test
	public void testPlanWithEmptyShiftsAndEmployeeService() {
		SimplePlanner planner = new SimplePlanner();

		Shifts shifts = Mockito.mock(Shifts.class);
		EmployeeService eService = Mockito.mock(EmployeeService.class);

		Mockito.when(shifts.getDaysInMonth()).thenReturn(0);
		Mockito.when(eService.findNext(Mockito.any(IJob.class))).thenReturn(null);

		Plan plan = planner.plan(shifts, eService);

		assertNotNull(plan);
		assertNotNull(plan.getPlan());
		assertEquals(0, plan.getPlan().size());
	}

	@Test
	public void testPlanServiceWithMocked() {
		SimplePlanner planner = new SimplePlanner();

		Shifts shifts = Mockito.mock(Shifts.class);
		EmployeeService eService = Mockito.mock(EmployeeService.class);
		
		Set<Shift> shiftsSet = new HashSet<Shift>();
		Shift shift = Mockito.mock(Shift.class);
		shiftsSet.add(shift);

		Mockito.when(shift.getCarType()).thenReturn(ECarType.ESETKOCSI);
		Mockito.when(shifts.getDaysInMonth()).thenReturn(1);
		Mockito.when(shifts.getShiftsForDay(Mockito.anyInt())).thenReturn(shiftsSet);
		Mockito.when(eService.findNext(Mockito.any(IJob.class))).thenReturn(null);

		Plan plan = planner.plan(shifts, eService);

		assertNotNull(plan);
		assertNotNull(plan.getPlan());
		assertEquals(1, plan.getPlan().size());
	}
}
