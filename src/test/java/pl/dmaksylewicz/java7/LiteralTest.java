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
	public void test_binaryValue() throws Exception {
		byte expected = 33;
		byte result = literals.getBinaryValue();
		assertEquals(expected, result);
	}

	@Test
	public void test_getWellFormattedValues() throws Exception {
		long[] expected = new long[] { 111222333L, 12L, 10 };
		long[] result = literals.getWellFormattedValues();
		for (int i = 0; i < result.length; i++) {
			assertEquals(expected[i], result[i]);
		}
	}
}
