package pl.dmaksylewicz.java7;

public class Literal {

	public byte getBinaryLiteral() {
		return 0b00100001;
	}

	public long[] getLiteralsWithUnderscore() {
		// 0_12 is an octal literal equals to 10 as decimal
		return new long[] { 111_222_333L, 1______2L, 0_12 };
	}
}
