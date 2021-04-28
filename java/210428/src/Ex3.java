
public class Ex3 {

	public static void main(String[] args) {

		// 접근제한자
		// public > protected > default > private
		
		Person3 p3 = new Person3();
		p3.name = "홍길동";
		p3.age = 22;
		
		Person4 p4 = new Person4();
//		p4.name = "홍길동";
//		p4.age = 22;
		// 오류! The field Person4.멤버변수명 is not visible
		// 외부 클래스에서 인스턴스를 통해 접근할 때 멤버변수가 보이지 않음 => 값 변경 불가
		// => 변수 값에 대신 접근해주는 메서드 정의하여 외부와 상호작용을 통해 멤버변수를 간접적으로 제어 
		
	}

}

class Person3 {
	
	//접근 제한자 생략 → default 적용
	String name;
	int age;
	
}

class Person4 {
	
	private String name;
	private int age;
	
}