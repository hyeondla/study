package collection_framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex4 {

	public static void main(String[] args) {
		
		// Map
		
		Map map = new HashMap();
		map.put(1, "JAVA");
		map.put(2, "JSP");
		map.put(3, "Android");
		
		System.out.println("모든 엔트리 : " + map);
		
		// 기존 데이터를 덮어씀 -> 제거되는 데이터가 리턴됨
		map.put(3, "Spring framework");
		System.out.println(map);
		System.out.println(map.put(4, "Android")); // null 리턴
		System.out.println(map.put(3, "Android")); // Spring framework 리턴 
		System.out.println(map);
		
		// key에 해당하는 값 리턴
		System.out.println(map.get(2)); // JSP 리턴
		System.out.println(map.get("2")); // null 리턴
		
		Set keySet = map.keySet();
		System.out.println("모든 키 : " + keySet);
		
		// value에 해당하는 값 리턴
//		List valueList = (List)map.values(); // 직접 다운캐스팅 불가
		List valueList = new ArrayList(map.values());
		System.out.println("모든 값 : " + valueList);
		
//		Iterator ite = map.iterator();
//		for(Map.Entry<String, String> entry : map) {}
		//=> Map 객체 크기만큼 반복하여 차례대로 요소 접근 불가
		//=> keySet(), values() 결과를 사용하여 반복
		for(Object o : keySet) {
			System.out.println(map.get(o));
		}
		
		Set entrySet = map.entrySet();
		System.out.println(entrySet);
		
		
		System.out.println("============================================");
		
		// <키 타입, 값 타입>
		Map<String, String> map2 = new HashMap<String, String>();
		
		map2.put("010-1234-5678", "홍길동");
		map2.put("010-1234-1234", "홍길동");
		map2.put("010-3434-3434", "이순신");
		map2.put("010-3434-3434", "강감찬");
		System.out.println(map2);
		
		// 특정 값 탐색
		System.out.println("홍길동 : " + map2.containsValue("홍길동"));
		System.out.println("이순신 : " + map2.containsValue("이순신"));
		
		// 특정 키 탐색
		System.out.println("010-1234-5678 : " + map2.containsKey("010-1234-5678"));
		
		
	}

}
