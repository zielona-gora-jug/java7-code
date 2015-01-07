package pl.dmaksylewicz.java7;

import org.junit.Before;
import org.junit.Test;

import pl.dmaksylewicz.java7.MultipleException.FirstException;

public class MultipleExceptionTest {

	private MultipleException ex;

	@Before
	public void setUp() {
		this.ex = new MultipleException();
	}

	@Test(expected = FirstException.class)
	public void test_t() throws Exception {
		int value = 1;
		ex.throwMultipleException(value);
	}
}
