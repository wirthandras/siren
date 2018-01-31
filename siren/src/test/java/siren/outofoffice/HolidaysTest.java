package siren.outofoffice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HolidaysTest {

	private Holidays h;
	private EOutType t;

	@Before
	public void setUp() {
		h = new Holidays();
		t = EOutType.HOLIDAY;
		h.put(1, t);
	}

	@Test
	public void test() {
		Assert.assertEquals(t, h.get(1));
	}

	@Test
	public void testHolidays() {
		h.put(2, EOutType.SICK);
		Assert.assertEquals(1, h.getNumberOfHolidays());
		Assert.assertEquals(1, h.getHolidays().size());
	}
	
	@Test
	public void testSicks() {
		Assert.assertEquals(0, h.getSicks().size());
		h.put(2, EOutType.SICK);
		Assert.assertEquals(1, h.getSicks().size());
	}

}
