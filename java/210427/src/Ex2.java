
public class Ex2 {

	public static void main(String[] args) {

		Person p1 = new Person();

		p1.name = "짝";
		p1.age = 25;

		p1.print();

		System.out.println("-----------------");

		Person p2 = new Person();

		p2.name = "꿍";
		p2.age = 30;

		p2.print();

	}

}

class Person {
	// 멤버변수 선언
	String name;
	int age;

	public void print() {
		// 클래스 내의 메서드에서 자신의 클래스 멤버변수에 자유롭게 접근 가능
		// 변수명 만으로 멤버변수 값 사용 가능
		// => 인스턴스에 따라 저장된 값이 달라짐
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}

}