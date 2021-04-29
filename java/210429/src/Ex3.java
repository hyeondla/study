
public class Ex3 {

	public static void main(String[] args) {

		Person3 p = new Person3("홍길동", 20);
		p.showPersonInfo();

		Person3 p2 = new Person3("이순신", 44);
		p.showPersonInfo();

	}

}

class Person3 {

	String name, nation;
	int age;

	public Person3(String name, int age) {
		System.out.println("Person3(String, int) 생성자 호출");
		this.name = name;
		this.age = age;
		nation = "대한민국";
	}

	public void showPersonInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("국가 : " + nation);
	}

	// 단축키 : Alt+Shift+S → O
//	public Person3(String name, String nation, int age) {
//		super();
//		this.name = name;
//		this.nation = nation;
//		this.age = age;
//	}
}