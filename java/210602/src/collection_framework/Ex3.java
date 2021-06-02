package collection_framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex3 {

	public static void main(String[] args) {
		
		// List
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		System.out.println(list);
		
		System.out.println("중복 추가 : " + list.add(3));
		System.out.println(list);
		
		// Object get(int index)
		System.out.println("인덱스 1에 저장된 요소 : " + list.get(1)); // 리턴타입 Integer(Object -> 제네릭 지정)
//		System.out.println(list.get(4)); // 오류! IndexOutOfBoundsException
		
		// int indexOf(Object o)
		System.out.println("정수 3이 저장된 인덱스 : " + list.indexOf(3));
		System.out.println("정수 3이 저장된 인덱스 : " + list.lastIndexOf(3));
		
		// Object remove(int index) 
//		System.out.println("정수 2 삭제 : " + list.remove(2));
		//=> 정수 데이터를 지정하면 인덱스로 취급됨 => 2번 인덱스가 삭제됨
		//=> 1. Object 타입으로 변환
//		System.out.println("정수 2 삭제 : " + list.remove((Object)2));
		//=> 2. indexOf() 탐색된 요소 삭제
		System.out.println("정수 2 삭제 : " + list.remove(list.indexOf(2)));
		System.out.println(list);
	
		// add(int index, Object o)
		list.add(1, 5); // 기존 데이터는 뒤로 밀려남
		System.out.println(list);
		
		// set(int index, Object o)
		list.set(1, 10); // 기존 데이터에 덮어씀
		System.out.println(list);
		
		// subList(int beginIndex, int endIndex)
		List subList = list.subList(1, 3); // beginIndex ~ endIndex-1 추출
		System.out.println(subList);
		
		System.out.println("============================================");

		List list2 = new ArrayList();
		list2.addAll(list);
		list2.add(20);
		list2.add(8);
		list2.add(85);
		list2.add(50);
		System.out.println("정렬 전 : " + list2);
		
		// Collections.sort(List)
		Collections.sort(list2); // 같은 데이터타입만 가능
		System.out.println("정렬 후 : " + list2);
		
		// Collections.shuffle(List)
		list2.add("888"); // 다른 데이터타입도 가능
		Collections.shuffle(list2);
		System.out.println("셔플 후 : " + list2);
		
		System.out.println("============================================");
		
//		String[] names = {"홍길동", "이순신", "강감찬"};
//		List namesList = Arrays.asList(names);
		
		List namesList = Arrays.asList("홍길동", "이순신", "강감찬");
		System.out.println(namesList);
		
	}

}
