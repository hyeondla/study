package collection_framework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex {

	public static void main(String[] args) {
		
		// HashSet
//		HashSet set = new HashSet();
		
		// Set으로 업캐스팅해서 사용
		Set set = new HashSet();
		
		// boolean isEmpty()
		System.out.println("set 객체가 비어있음 : " + set.isEmpty());
		
		// int size()
		System.out.println("set 객체에 저장된 요소 개수 : " + set.size());
		
		// boolean add(Object o)
		set.add(1); // int -> Integer (오토박싱) -> Object (업캐스팅)
		set.add("TWO"); // String -> Object
		set.add(3.14); // double -> Double -> Object
	
		System.out.println("set 객체가 비어있음 : " + set.isEmpty());
		System.out.println("set 객체에 저장된 요소 개수 : " + set.size());
		
		// String toString()
		System.out.println("set 객체의 모든 요소 : " + set);
		
		System.out.println("set 객체에 중복되는 요소 추가 : " + set.add(3.14)); //false
		System.out.println("set 객체에 새로운 요소 추가 : " + set.add(4)); //true
		System.out.println("set 객체의 모든 요소 : " + set);
		
		set.add(5);
		set.add("six");
		
		System.out.println("set 객체에 저장된 요소 개수 : " + set.size());
		System.out.println("set 객체의 모든 요소 : " + set);
		
		System.out.println("--------------------------------------------");
		
		// boolean contains(Object o)
		System.out.println("set 객체에 3.14 존재 : " + set.contains(3.14)); //true
		System.out.println("set 객체에 3 존재 : " + set.contains(3)); //false
		
		// boolean remove(Object o)
		System.out.println("3.14 삭제 : " + set.remove(3.14)); //true 
		System.out.println("3.14 삭제 : " + set.remove(3.14)); //false
		System.out.println(set);
		
		// void clear()
//		set.clear();
//		System.out.println(set);
		
		// Object[] toArray()
		Object[] oArr = set.toArray();
		System.out.println(Arrays.toString(oArr));
		
		System.out.println("============================================");
		
		Set set2 = new HashSet(set); // 요소 전체 복사
		set.remove(5);
		System.out.println("set 객체 : " + set);
		System.out.println("set2 객체 : " + set2);
		
		Set set3 = new HashSet();
		set3.add(10);
		set3.add(5);
		set3.addAll(set);
		System.out.println(set3);
		
		System.out.println("============================================");

		Set set4 = new HashSet();
//		set4.add("300");
//		set4.add("30");
//		set4.add("200");
//		set4.add("1");
//		set4.add("100");
//		set4.add("10");
		// [1, 10, 100, 200, 30, 300]
		
		set4.add(300);
		set4.add(30);
		set4.add(200);
		set4.add(1);
		set4.add(100);
		set4.add(10);
		// [1, 10, 30, 100, 200, 300]
		
		System.out.println(set4);

		// TreaSet => 오름차순 정렬 (같은 타입 데이터만 가능 ) 
		TreeSet treeSet = new TreeSet(set4);
		System.out.println(treeSet);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
