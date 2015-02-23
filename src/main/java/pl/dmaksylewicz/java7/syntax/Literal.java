package pl.dmaksylewicz.java7.syntax;

public class Literal {

	public byte getBinaryValue() {
		return 0b00100001;
	}

	public long[] getWellFormattedValues() {
		// 0_12 is octal literal = 10 in decimal
		return new long[] { 111_222_333L, 1______2L, 0_12 };
	}
}
