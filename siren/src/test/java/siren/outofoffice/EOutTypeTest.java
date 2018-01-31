package siren.outofoffice;

import org.junit.Assert;
import org.junit.Test;

public class EOutTypeTest {

	private int expectedSizeOfEnum = 2;

	@Test
	public void testEnums() {
		Assert.assertEquals(EOutType.HOLIDAY, EOutType.valueOf(EOutType.HOLIDAY.toString()));
		Assert.assertEquals(EOutType.SICK, EOutType.valueOf(EOutType.SICK.toString()));
		Assert.assertEquals(expectedSizeOfEnum, EOutType.values().length);
	}

}
