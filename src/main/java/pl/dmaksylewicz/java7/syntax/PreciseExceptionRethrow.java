package pl.dmaksylewicz.java7.syntax;

import java.net.ConnectException;
import java.sql.SQLException;

public class PreciseExceptionRethrow {

	// Java < 7

	// compile error, when something different is thrown than exception
	public void loadSomethingFromResourceBefore() throws Exception {
		try {
			open();
			query();
		} catch (final Exception e) {
			e.printStackTrace();
			System.out.println("do something when can't connect");
			throw e;
		}
	}

	// Java >= 7

	public void loadSomethingFromResourceAfter() throws ConnectException, SQLException {
		try {
			open();
			query();
		} catch (final Exception e) {
			// note final : the compile knows to re-throw only declared
			// exceptions, that are also not caught
			e.printStackTrace();
			System.out.println("do something when can't connect");
			throw e;
		}
	}

	private void open() throws ConnectException {
		throw new ConnectException("Can't open connection");
	}

	private void query() throws SQLException {
		throw new SQLException("Can't query db");
	}
}
