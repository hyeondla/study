
public class Ex4 {

	public static void main(String[] args) {

		Manager4 m = new Manager4();
		
		System.out.println("--------------------");
		
//		Manager4 m2 = new Manager4("홍길동", 5000);
		//오류! 생성자는 상속 X
		
		Manager4 m3 = new Manager4("홍길동", 5000, "개발");
		
	}

}

class Employee4 {
	
	String name;
	int salary;
	
	public Employee4() {
		//슈퍼클래스 기본생성자가 없을때 서브클래스 생성자에서 컴파일 에러!
		System.out.println("Employee4() 생성자 호출");
	}

	public Employee4(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
}

class Manager4 extends Employee4 {
	
	String depart;
	
	public Manager4() {
		//슈퍼클래스 기본생성자 자동 호출 -> 서브클래스 생성자 작업 수행
		System.out.println("Manager4() 생성자 호출");
	}

	public Manager4(String name, int salary, String depart) {
		System.out.println("Manager4(String, int, String) 생성자 호출");
		this.name = name;
		this.salary = salary;
		this.depart = depart;
	}
	
}