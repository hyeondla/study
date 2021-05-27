
public class Ex {

	public static void main(String[] args) {

		String str = new String("자바"); 
		System.out.println(str);
		System.out.println(str.toString());
		
		
		//toString()
		Person p = new Person("홍길동", 20, "990909-1234567");
		System.out.println("사람 p의 정보 : " + p.toString());
		System.out.println("사람 p의 정보 : " + p);
		//=> println() 메서드 내에 객체 정보 출력시 toString() 생략 가능
		//   출력문이 아닌 변수에 값을 저장하는 경우 toString() 필수
		String personInfo = p.toString();
		
		//Object.toString() => "클래스명@주소값" 문자열 리턴
		System.out.println("Person p의 클래스명 : " + p.getClass().getName());
		System.out.println("Person p의 주소값 : " + p.hashCode());
		
		System.out.println("--------------------------------------------");
		
		Person2 p2 = new Person2("홍길동", 20, "990909-1234567");
		System.out.println("p2 객체의 정보 : " + p2.toString());
		System.out.println("p2 객체의 정보 : " + p2);
		
	}

}

class Person {
	String name;
	int age;
	String jumin;
	
	public Person(String name, int age, String jumin) {
		super();
		this.name = name;
		this.age = age;
		this.jumin = jumin;
	}
}

class Person2 {
	String name;
	int age;
	String jumin;
	
	public Person2(String name, int age, String jumin) {
		super();
		this.name = name;
		this.age = age;
		this.jumin = jumin;
	}
	
	//자동완성
	@Override
	public String toString() {
		return "Person2 [name=" + name + ", age=" + age + ", jumin=" + jumin + "]";
	}

//	@Override
//	public String toString() {
//		return "이름 : " + name + ", 나이 : " + age + ", 주민 : " + jumin;
//	}
	
	
	
}

