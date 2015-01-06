package pl.dmaksylewicz.java7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SwitchStatementTest {

	private SwitchStatement statements;

	@Before
	public void setUp() {
		statements = new SwitchStatement();
	}

	public void test_valueOfTrue() {
		String toConvert = "true";
		boolean result = statements.valueOf(toConvert);
		assertTrue(result);
	}

	public void test_valueOfFalse() {
		String toConvert = "false";
		boolean result = statements.valueOf(toConvert);
		assertFalse(result);
	}

	@Test(expected = RuntimeException.class)
	public void test_valueOfWhenUnknown() {
		String toConvert = "fake";
		statements.valueOf(toConvert);
	}
}
