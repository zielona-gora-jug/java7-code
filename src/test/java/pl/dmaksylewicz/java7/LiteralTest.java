package pl.dmaksylewicz.java7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LiteralTest {

	private Literal literals;

	@Before
	public void setUp() {
		literals = new Literal();
	}

	@Test
	public void test_getBinaryLiteral() throws Exception {
		byte expected = 33;
		byte result = literals.getBinaryLiteral();
		assertEquals(expected, result);
	}

	@Test
	public void test_getLiteralWithUnderscore() throws Exception {
		long[] expected = new long[] { 111222333L, 12L, 10 };
		long[] result = literals.getLiteralsWithUnderscore();
		for (int i = 0; i < result.length; i++) {
			assertEquals(expected[i], result[i]);
		}
	}
}
