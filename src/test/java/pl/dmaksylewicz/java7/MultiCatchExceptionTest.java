package pl.dmaksylewicz.java7;

import org.junit.Before;
import org.junit.Test;

import pl.dmaksylewicz.java7.syntax.MultiCatchException;
import pl.dmaksylewicz.java7.syntax.MultiCatchException.MyFirstException;
import pl.dmaksylewicz.java7.syntax.MultiCatchException.MySecondException;
import static org.junit.Assert.assertEquals;

public class MultiCatchExceptionTest {

	private MultiCatchException catcher;

	@Before
	public void setUp() {
		this.catcher = new MultiCatchException();
	}

	@Test(expected = MyFirstException.class)
	public void test_getValueAsIntWhenMyFirstExceptionIsThrown() throws Exception {
		String value = "1";
		catcher.getValueAsIntAfter(value);
	}

	@Test(expected = MySecondException.class)
	public void test_getValueAsIntWhenMySecondExceptionIsThrown() throws Exception {
		String value = "2";
		catcher.getValueAsIntAfter(value);
	}

	@Test
	public void test_getValueAsIntWhenCorrectValue() throws Exception {
		String value = "3";
		int expected = 3;
		int result = catcher.getValueAsIntAfter(value);
		assertEquals(expected, result);
	}
}
