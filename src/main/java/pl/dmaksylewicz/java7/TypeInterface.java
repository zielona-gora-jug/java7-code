package pl.dmaksylewicz.java7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeInterface {

	public Map<Integer, String> getIdToNameMap() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Bonifacy");
		map.put(2, "Baltazar");
		return map;
	}

	public List<Integer> getIds() {
		List<Integer> list = new ArrayList<>();
		list.add(111);
		list.add(222);
		list.add(333);
		return list;
	}
}
