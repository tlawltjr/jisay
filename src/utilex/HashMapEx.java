package utilex;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "조기제");
		map.put(2, "임진우");
		map.put(3, "김동환");
		map.put(4, "박동원");
		map.put(5, "정주호");

		for (int i = 1; i <= map.size(); i++) {
			System.out.println(map.get(i));
		}

		getMap(map);

	}// End of main

	static void getMap(Map map) {
		// map 타입으로 데이터를 받아서 전체 키를 찾고, value 를 찾고, Collection
		// 타입으로 변형 하여 출력해보자.
		if (map != null) {
			Set<Integer> set = map.keySet();
			Object[] keys = set.toArray();
			for (int i = 0; i < keys.length; i++) {
				System.out.println(map.get(keys[i]));
			}

		}

	}

}
