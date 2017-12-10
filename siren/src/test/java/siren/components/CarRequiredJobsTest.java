package siren.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import siren.jobs.IJob;
import siren.jobs.JobFactory;

public class CarRequiredJobsTest {

	@Test
	public void test() {
		CarRequiredJobs clazz = new CarRequiredJobs();

		assertNotNull(clazz);
	}

	@Test
	public void testEsetKocsi() {
		Set<IJob> jobs = CarRequiredJobs.get(ECarType.ESETKOCSI);

		assertEquals(2, jobs.size());
		assertTrue(jobs.contains(JobFactory.nurse));
		assertTrue(jobs.contains(JobFactory.driver));
	}

	@Test
	public void testRohamKocsi() {
		Set<IJob> jobs = CarRequiredJobs.get(ECarType.ROHAMKOCSI);

		assertEquals(3, jobs.size());
		assertTrue(jobs.contains(JobFactory.nurse));
		assertTrue(jobs.contains(JobFactory.driver));
		assertTrue(jobs.contains(JobFactory.paramedic));
	}
}
