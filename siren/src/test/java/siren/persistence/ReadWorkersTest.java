package siren.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class ReadWorkersTest {
	
	@Test
	public void testConstructor() {
		ReadWorkers o = new ReadWorkers();
		assertNotNull(o);
	}

	@Test
	public void test() throws IOException {
		File testFile = new File("src/test/resources/siren/persistence/testEmployees.txt");
		assertEquals(35, ReadWorkers.readEmployees(testFile).size());
	}
}
