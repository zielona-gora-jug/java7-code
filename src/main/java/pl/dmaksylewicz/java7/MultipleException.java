package pl.dmaksylewicz.java7;

public class MultipleException {

	public void throwMultipleException(int value) throws Exception {
		try {
			if (value == 1) {
				throw new FirstException("First ex");
			}
			if (value == 2) {
				throw new SecondException("Second ex");
			}
		} catch (FirstException | SecondException e) {
			throw e;
		}
	}

	public class FirstException extends Exception {
		public FirstException(String string) {
			super(string);
		}
	}

	public class SecondException extends Exception {
		public SecondException(String string) {
			super(string);
		}
	}
}
