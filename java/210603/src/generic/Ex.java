package generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex {

	public static void main(String[] args) {

		NormalClass nc = new NormalClass();
		
		//Object 타입 -> 모든 데이터타입 저장 가능
		nc.setMember(1);
//		nc.setMember("홍길동");
		
		//Object 타입으로 저장
		Object o = nc.getMember();
		//실제 데이터 타입으로 변환 -> 다운캐스팅
//		String name = (String)o;
//		System.out.println(name);
		//=> 잘못된 타입 변환으로 인해 ClassCastException 발생 가능
		//=> 변환 전 반드시 instanceof 연산자를 통한 타입 체크
		
		System.out.println("============================================");
		
		//참조 데이터 타입 명시
//		GenericClass<int> gc = new GenericClass<int>(); //오류!
		GenericClass<Integer> gc = new GenericClass<Integer>();
		//=> T가 Integer 타입으로 대체
		gc.setMember(1);
//		gc.setMember("홍길동"); //오류!
		
		int num = gc.getMember();
		
		GenericClass<Double> gc2 = new GenericClass<Double>();
		gc2.setMember(3.14);

		GenericClass<String> gc3 = new GenericClass<String>();
		gc3.setMember("홍길동");
		
		Person p = new Person("홍길동", 20);
		
		GenericClass<Person> gc4 = new GenericClass<Person>();
		gc4.setMember(p);
		gc4.setMember(new Person("홍길동", 20));
		
		Person person = gc4.getMember();
		
		//----------------------------------------------------
		
		//타입 지정을 안 할 경우 T가 Object 타입으로 대체됨
		GenericClass gc5 = new GenericClass(); 
		gc5.setMember(1);
		gc5.setMember("홍길동");
		gc5.setMember(new Person("홍길동", 20));
		
		
		//=======================================================
		
		List<String> list = new ArrayList<String>();
		
		Set<Integer> set = new HashSet<Integer>();
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		//키 Integer 값 String 고정
		
	}

}

//제네릭을 사용한 클래스 정의
//정확한 자료형 명시 X, 데이터 타입 대신 사용
//-> 인스턴스 생성 시점에 가상의 자료형을 대신할 실제 자료형을 지정
//-> 클래스 내 가상의 자료형이 실제 자료형으로 대체됨
class GenericClass<T> { //제네릭 타입 T 지정
	
	T member; //데이터 타입 T 지정

	public T getMember() {
		return member;
	}

	public void setMember(T member) {
		this.member = member;
	}
	
}

class NormalClass {
	
	Object member;

	public Object getMember() {
		return member;
	}

	public void setMember(Object member) {
		this.member = member;
	}
	
	
}