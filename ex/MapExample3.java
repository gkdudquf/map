package ex;

import java.util.*;

public class MapExample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, String > map3 = new HashMap<>();
		System.out.println("번호\t학번\t이름\t전공\t전화번호");
		map3.put(1, "\t1111\t김자바\t컴퓨터공학\t010-1111-1111");
		map3.put(2, "\t2222\t이자바\t경영학\t010-2222-2222");
		map3.put(3, "\t3333\t박자바\t전자공학\t010-3333-3333");
		
		for(int key: map3.keySet()) {
			System.out.print(key);
			System.out.println(map3.get(key));
		}
	}

}
