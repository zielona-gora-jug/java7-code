package pl.dmaksylewicz.java7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class TypeInterfaceTest {

	private TypeInterface collector;

	@Before
	public void setUp() {
		collector = new TypeInterface();
	}

	public void test_mapOfIdsToName() {
		Map<Integer, String> expected = new HashMap<>();
		expected.put(1, "Bonifacy");
		expected.put(2, "Baltazar");
		Map<Integer, String> result = collector.getIdToNameMap();
		assertEquals(expected, result);
	}

	public void test_getIdsAsList() {
		List<Integer> expected = new ArrayList<>();
		expected.add(111);
		expected.add(222);
		expected.add(333);
		List<Integer> result = collector.getIds();
		assertEquals(expected, result);
	}
}
