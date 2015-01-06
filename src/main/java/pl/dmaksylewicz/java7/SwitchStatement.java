package pl.dmaksylewicz.java7;

public class SwitchStatement {

	public boolean valueOf(String toConvert) {
		switch (toConvert) {
		case "true":
			return true;
		case "false":
			return false;
		default:
			throw new RuntimeException("Unknown value " + toConvert);
		}
	}
}
