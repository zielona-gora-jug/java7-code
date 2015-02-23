package pl.dmaksylewicz.java7.syntax;

public class SwitchStatement {

	public int getLanguagePopularity(String language) {
		switch (language) {
		case "java":
			return 5;
		case "scala":
			return 3;
		case "ruby":
			return 2;
		default:
			throw new RuntimeException("Requested unknown language -> " + language);
		}
	}
}
