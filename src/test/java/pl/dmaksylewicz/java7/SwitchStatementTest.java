package pl.dmaksylewicz.java7;

import org.junit.Before;
import org.junit.Test;

import pl.dmaksylewicz.java7.syntax.SwitchStatement;
import static org.junit.Assert.assertEquals;

public class SwitchStatementTest {

	private SwitchStatement statement;

	@Before
	public void setUp() {
		statement = new SwitchStatement();
	}

	@Test
	public void test_languagePopularity() {
		String[] languages = new String[] { "java", "scala", "ruby" };
		int[] expectedPopularity = new int[] { 5, 3, 2 };
		for (int i = 0; i < expectedPopularity.length; i++) {
			int result = statement.getLanguagePopularity(languages[i]);
			assertEquals(expectedPopularity[i], result);
		}
	}

	@Test(expected = RuntimeException.class)
	public void test_valueOfWhenUnknown() {
		String language = "fake";
		statement.getLanguagePopularity(language);
	}
}
