package siren.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import siren.jobs.Employee;

public class PlanTest {

	@Test
	public void testGetPlan() {
		Map<Shift, Set<Employee>> m = new HashMap<Shift, Set<Employee>>();
		Plan plan = new Plan(m);
		assertNotNull(plan.getPlan());
		assertEquals(m, plan.getPlan());
	}

}
