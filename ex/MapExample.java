package ex;

import java.util.*;

public class MapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, String> map1 = new HashMap<>();
		List<String> list1 = new ArrayList<>();
		
		map1.put(1, "안녕하세요");
		System.out.println(map1.put(2, "hello")); //null 출력 먼저담겨있는 값이 리턴
		System.out.println(map1.put(2, "ㅎㅎㅎㅎㅎㅎㅎㅎ")); //hello 출력		
		System.out.println(map1.get(2));
		
		String val1 = map1.get(1);
		System.out.println(val1);
		
		map1.remove(2); //2번에 있는 내용을 지우겠다
		System.out.println(map1.get(2));
		
		for(Integer key: map1.keySet()) {
			System.out.println(key);
			System.out.println(map1.get(key));
		}
	}

}
