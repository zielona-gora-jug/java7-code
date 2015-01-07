package pl.dmaksylewicz.java7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class TypeInterfaceTest {

	private TypeInterface typeInterfaces;

	@Before
	public void setUp() {
		typeInterfaces = new TypeInterface();
	}

	public void test_getDiamondMap() {
		Map<Integer, Integer> expected = new HashMap<Integer, Integer>();
		expected.put(1, 1);
		expected.put(2, 2);
		Map<Integer, Integer> result = typeInterfaces.getDiamondMap();
		assertEquals(expected, result);
	}

	public void test_getDiamondList() {
		List<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(2);
		List<Integer> result = typeInterfaces.getDiamondList();
		assertEquals(expected, result);
	}
}
