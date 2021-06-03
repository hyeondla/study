package generic;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		Person p1 = new Person("하나", 26);
		Person p2 = new Person("둘둘", 22);
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println("============================================");
		
		//Object[] 배열을 통해 관리
		//=> 추가 객체 저장 불가
		//=> 다운캐스팅 필요 (타입 체크 필수)
		Object[] objArr = {p1, p2}; //Person -> Object 업캐스팅
		for(int i=0; i<objArr.length; i++) {
//			Person p = objArr[i]; //오류! -> 다운캐스팅
			if(objArr[i] instanceof Person) {
			Person p = (Person)objArr[i]; //다운캐스팅 
			System.out.println(p.name + " " + p.age); //-> Person 타입 변수 접근
			}
		}
		
		System.out.println("============================================");
		
		//Collection (ArrayList)를 통해 관리
		//=> 추가 객체 저장 가능
		
		//제네릭 사용 X
		//=> 데이터타입 Object => 다양한 객체 저장 가능
		//=> 다운캐스팅 필요 (타입 체크 필수)
		List list = new ArrayList();
		list.add(p1);
		list.add(p2);
		list.add(new Person("세이", 30));
		list.add("네네");
		
		for(int i=0; i<list.size(); i++) {
//			Object o = list.get(i);
//			System.out.println(o.name); //참조영역 축소 -> Person 멤버 접근불가
			
//			if(list.get(i) instanceof Person) {
//				Person p = (Person)list.get(i);
//				System.out.println(p.name + " " + p.age);
//			}
		}

		for(Object o : list) {
			if(o instanceof Person) {
				Person p = (Person)o;
				System.out.println(p.name + " " + p.age);
			}
		}
		
		System.out.println("--------------------------------------------");
		
		//제네릭 사용
		
		List<Person> list2 = new ArrayList<Person>();
		list2.add(p1);
		list2.add(p2);
		list2.add(new Person("세이", 30));
//		list2.add("네네"); //오류!
		
		for(int i=0; i<list2.size(); i++) {
			Person p = list2.get(i); //형변환 불필요, 타입 체크 불필요
			System.out.println(p.name + " " + p.age);
		}
		
		for(Person p : list2) {
			System.out.println(p.name + " " + p.age);
		}
		
		
	}

}
