package pl.dmaksylewicz.java7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TryWithResourcesStatementTest {

	private static final String TEST_FILE_PATH = "./src/main/resources/test.txt";

	private TryWithResourcesStatement statement;

	@Before
	public void setUp() {
		this.statement = new TryWithResourcesStatement();
	}

	@Test
	public void test_readFirstLineWhenOneResource() throws Exception {
		String expected = "java user group zg";
		String result = this.statement.readFirstLineWhenOneRecource(TEST_FILE_PATH);
		assertEquals(expected, result);
	}

	@Test
	public void test_readFirstLineWhenMoreResources() throws Exception {
		String expected = "java user group zg";
		String result = this.statement.readFirstLineWhenMoreResources(TEST_FILE_PATH);
		assertEquals(expected, result);
	}

	@Test
	public void test_throwSuppressedException() throws Exception {
		String expectedTryCatchResMessage = "read line ex";
		String expectedSuppressedMessage = "close ex";
		try {
			this.statement.throwSuppressedException(TEST_FILE_PATH);
		} catch (Exception e) {
			assertEquals(expectedTryCatchResMessage, e.getMessage());
			for (Throwable t : e.getSuppressed()) {
				assertEquals(expectedSuppressedMessage, t.getMessage());
			}
		}
	}
}
