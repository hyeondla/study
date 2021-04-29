
public class Ex2 {

	public static void main(String[] args) {

		System.out.println("인스턴스 생성 전");
		Person2 p = new Person2(); // => 생성자는 반드시 new 키워드 뒤에만
		System.out.println("인스턴스 생성 후");

//		p.name = "홍길동";
//		p.age = 20;

		System.out.println("이름 : " + p.name);
		System.out.println("나이 : " + p.age);

	}

}

class Person2 {

	String name;
	int age;

	// 생성자 => 인스턴스 변수 초기화, 초기 수행 작업 기술
	// 별도 선언 없어도 자바 컴파일러에 의해 기본 생성자 자동 생성
	// 기본 생성자는 접근제한자가 클래스와 같음
	// 리턴 타입 없음
	// 이름이 클래스 이름과 같음
	// 매개변수가 없음
	// 중괄호 블록 내에 수행할 코드 없음
//	public Person2() {}

//	public Person2() {
//		System.out.println("생성자 Person2() 호출됨");
//	}

	public Person2() {
		System.out.println("생성자 Person2() 호출됨");

		name = "홍길동";
		age = 20;
	}

}