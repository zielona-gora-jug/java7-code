package pl.dmaksylewicz.java7;

public class MultiCatchException {

	// Java < 7

	public int getValueAsIntBefore(String srcValue) throws MyFirstException, MySecondException {
		int destValue = Integer.valueOf(srcValue);
		try {
			switch (destValue) {
			case 1:
				throw new MyFirstException("First ex");
			case 2:
				throw new MySecondException("Second ex");
			default:
				return destValue;
			}
		} catch (MyFirstException e) {
			System.out.println("do something, when any exception is caught...");
			throw e;
		} catch (MySecondException e) {
			System.out.println("again do something similar, as above, when any exception is caught...");
			throw e;
		}
	}

	// Java >= 7

	public int getValueAsIntAfter(String srcValue) throws MyFirstException, MySecondException {
		int destValue = Integer.valueOf(srcValue);
		try {
			switch (destValue) {
			case 1:
				throw new MyFirstException("First ex");
			case 2:
				throw new MySecondException("Second ex");
			default:
				return destValue;
			}
		} catch (MyFirstException | MySecondException e) {
			System.out.println("do something, when any exception is caught...");
			throw e;
		}
	}

	public class MyFirstException extends Exception {

		private static final long serialVersionUID = -7054660544024679135L;

		public MyFirstException(String string) {
			super(string);
		}
	}

	public class MySecondException extends Exception {

		private static final long serialVersionUID = -3401316128851239636L;

		public MySecondException(String string) {
			super(string);
		}
	}
}
