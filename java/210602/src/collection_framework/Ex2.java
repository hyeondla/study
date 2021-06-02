package collection_framework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex2 {

	public static void main(String[] args) {
		
		Set set = new HashSet();
		set.add(300);
		set.add(30);
		set.add(200);
		set.add(1);
		set.add(100);
		set.add(10);
		
		// 제네릭 타입 지정 X -> Object 타입
		for(Object o : set) { // forEach (향상된 for문)
			System.out.println(o);
		}
		
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(1);
		set2.add(2);
		set2.add(3);
		set2.add(4);
		set2.add(5);
		set2.add(6);
		
		for(int i : set2) {
			System.out.println(i);
		}
		
		System.out.println("============================================");
		
		// Iterator(반복자)
		Iterator ite = set.iterator(); // Iterator 객체 얻어옴
		while(ite.hasNext()) { // 다음 요소가 존재할 동안 반복
			System.out.println(ite.next());
		}
				
		// 제네릭 타입 지정
		Iterator<Integer> ite2 = set2.iterator(); // 정수 타입 관리
		while(ite2.hasNext()) {
//			System.out.println(ite2.next());
			int num = ite2.next();
			System.out.println(set.contains(num));
		}
		
				
	}

}
