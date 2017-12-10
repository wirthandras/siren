package siren.components;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CarTest {

	private String IDENTIFIER = "REN-001";
	private Car car;

	@Before
	public void setup() {
		car = new Car(IDENTIFIER, ECarType.ESETKOCSI);
	}

	@Test
	public void testCarIdentifier() {
		assertEquals(IDENTIFIER, car.getIdentifier());
	}

	@Test
	public void testCarType() {
		assertEquals(ECarType.ESETKOCSI, car.getCarType());
	}

	@Test
	public void testToString() {
		assertEquals(IDENTIFIER + "," + ECarType.ESETKOCSI.toString(), car.toString());
	}

}
