package pl.dmaksylewicz.java7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TryWithResourcesStatementTest {

	private static final String TEST_FILE_PATH = "./src/main/resources/test1.txt";

	private TryWithResourcesStatement resource;

	@Before
	public void setUp() {
		this.resource = new TryWithResourcesStatement();
	}

	@Test
	public void test_readSingleLine() throws Exception {
		String expected = "java user group zg";
		String result = this.resource.readSingleLine(TEST_FILE_PATH);
		assertEquals(expected, result);
	}

	// Java < 7

	@Test
	public void test_throwExceptionBefore() throws Exception {
		// String expectedTryCatchMessage = "read line ex";
		String expectedSuppressedMessage = "close ex";
		try {
			this.resource.throwExceptionWhenReadSingleLineBefore(TEST_FILE_PATH);
		} catch (Exception e) {
			// WTF ?! where is thrown "read line ex" ?!
			assertEquals(expectedSuppressedMessage, e.getMessage());
			for (Throwable t : e.getSuppressed()) {
				assertEquals(expectedSuppressedMessage, t.getMessage());
			}
		}
	}

	// Java >= 7

	@Test
	public void test_throwExceptionAfter() throws Exception {
		String expectedTryCatchMessage = "read line ex";
		String expectedSuppressedMessage = "close ex";
		try {
			this.resource.throwExceptionWhenReadSingleLineAfter(TEST_FILE_PATH);
		} catch (Exception e) {
			assertEquals(expectedTryCatchMessage, e.getMessage());
			for (Throwable t : e.getSuppressed()) {
				assertEquals(expectedSuppressedMessage, t.getMessage());
			}
		}
	}

	@Test
	public void test_pingStatusAndMyAutoCloseable() throws Exception {
		int expected = 1;
		int result = this.resource.ping();
		assertEquals(expected, result);
	}
}
