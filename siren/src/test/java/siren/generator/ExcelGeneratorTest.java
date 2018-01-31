package siren.generator;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import siren.components.Plan;
import siren.jobs.Employee;
import siren.jobs.EmployeeService;
import siren.jobs.IJob;
import siren.jobs.JobFactory;
import siren.outofoffice.Holidays;
import siren.outofoffice.OutOfOffice;

public class ExcelGeneratorTest {

	private final int testDays = 20;

	@Test
	public void test() throws IOException {
		Plan plan = Mockito.mock(Plan.class);
		Mockito.when(plan.getDays()).thenReturn(testDays);

		EmployeeService employeeService = Mockito.mock(EmployeeService.class);
		Set<Employee> emps = new HashSet<Employee>();
		emps.add(new Employee("A", JobFactory.driver, false));
		Mockito.when(employeeService.filter(Mockito.any(IJob.class))).thenReturn(emps);

		Holidays h = Mockito.mock(Holidays.class);
		Set<Integer> holidays = new HashSet<Integer>();
		holidays.add(3);
		Mockito.when(h.getHolidays()).thenReturn(holidays);
		Set<Integer> sicks = new HashSet<Integer>();
		sicks.add(4);
		Mockito.when(h.getSicks()).thenReturn(sicks);

		OutOfOffice out = Mockito.mock(OutOfOffice.class);
		Mockito.when(out.get(Mockito.any())).thenReturn(h);

		ExcelGenerator gen = new ExcelGenerator(plan, employeeService, out);
		Assert.assertNotNull(gen.generate());
		Assert.assertEquals(3, gen.generate().getNumberOfSheets());

		Mockito.when(plan.isNormalShiftDay(Mockito.any(), Mockito.anyInt())).thenReturn(true);
		Assert.assertNotNull(gen.generate());
		Assert.assertEquals(3, gen.generate().getNumberOfSheets());
	}
}
