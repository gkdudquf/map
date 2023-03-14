package ex;

import java.util.*;

public class MapExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, String> map2 = new HashMap<>();
		map2.put("첫번째", "java");
		map2.put("두번째", "mysql");
		map2.put("세번째", "spring");
		
		System.out.println(map2.get("두번째"));
		
		map2.remove("세번째");
		System.out.println(map2.get("세번째"));
	
		//map 반복문으로 접근
		for(String key: map2.keySet()) {
			System.out.println(key); //key값 확인
			System.out.println(map2.get(key)); //value값 확인
		}
	}

}
