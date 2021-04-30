
public class Ex2 {

	public static void main(String[] args) {

		Person p = new Person("대한민국", "홍길동", "901010-1234567");
		p.showPersonInfo();
		
		System.out.println("---------------------------------");
		
		Person p2 = new Person("홍길동", "901010-1234567");
		p2.showPersonInfo();
		
		System.out.println("---------------------------------");
		
		Person p3 = new Person();
	}

}

class Person {
	String nation;
	String name;
	String jumin;

	public Person(String nation, String name, String jumin) {
		System.out.println("Person(String, String, String) 생성자 호출");
		this.nation = nation;
		this.name = name;
		this.jumin = jumin;
	}
	
	public Person(String name, String jumin) {
		System.out.println("Person(String, String) 생성자 호출");
		nation = "대한민국";
		this.name = name;
		this.jumin = jumin;
	}

	public Person() { 
		System.out.println("Person() 생성자 호출");
	}

	public void showPersonInfo() {
		System.out.println("국가명 : " + nation);
		System.out.println("이름 : " + name);
		System.out.println("주민번호 : " + jumin);
		
	}
	
}