package pl.dmaksylewicz.java7;

import java.net.ConnectException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import pl.dmaksylewicz.java7.syntax.PreciseExceptionRethrow;

public class PreciseExceptionRethrowTest {

	private PreciseExceptionRethrow datasource;

	@Before
	public void setUp() {
		this.datasource = new PreciseExceptionRethrow();
	}

	@Test(expected = ConnectException.class)
	public void test_loadSomethingFromResourceAfter() throws ConnectException, SQLException {
		this.datasource.loadSomethingFromResourceAfter();
	}
}
