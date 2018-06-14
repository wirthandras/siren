package siren.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import siren.components.Car;

public class ModelTest {

	private final String newIdentifier = "AAA-001";

	private Model m;

	@Before
	public void setup() {
		m = new Model();
	}

	@Test
	public void testCarListShouldBeEmpty() {
		Assert.assertTrue(m.getCars().isEmpty());
	}

	@Test
	public void testCarListShouldBeNotEmpty() {
		addTestCar();

		Assert.assertFalse(m.getCars().isEmpty());
		Assert.assertEquals(1, m.getCars().size());
	}

	@Test
	public void testIdentifierShouldBeNotExist() {
		Assert.assertFalse(m.identifierIsExist(newIdentifier));
	}

	@Test
	public void testIdentifierShouldBeExist() {
		addTestCar();

		Assert.assertTrue(m.identifierIsExist(newIdentifier));
	}

	private void addTestCar() {
		Car c = Mockito.mock(Car.class);
		Mockito.when(c.getIdentifier()).thenReturn(newIdentifier);

		m.addCar(c);
	}

	@Test
	public void testEmployeeServiceNotNull() {
		assertNotNull(m.getEmployeeService());
	}

}
