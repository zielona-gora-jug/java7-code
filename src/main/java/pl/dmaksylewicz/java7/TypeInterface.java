package pl.dmaksylewicz.java7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeInterface {

	public Map<Integer, Integer> getDiamondMap() {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		return map;
	}

	public List<Integer> getDiamondList() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		return list;
	}
}
