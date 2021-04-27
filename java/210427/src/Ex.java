
public class Ex {

	public static void main(String[] args) {

//		Animal ani;
//		ani = new Animal();
		Animal ani = new Animal();

		ani.name = "멍멍이";
		System.out.println(ani.name);

		ani.age = 3;
		System.out.println(ani.age);

		ani.cry();

		System.out.println("------------------------------");

		Animal ani2 = new Animal();

		ani2.name = "야옹이";
		System.out.println(ani2.name);

		ani2.age = 2;
		System.out.println(ani2.age);

		ani2.cry();

		System.out.println("================================");

		Car car = new Car();

		car.company = "현대";
		car.modelName = "그랜져";
		car.cc = 3000;

		System.out.println("제조사 : " + car.company);
		System.out.println("모델명 : " + car.modelName);
		System.out.println("배기량 : " + car.cc);

		car.speedUp();
		car.speedDown();

		System.out.println("=============================");

		Student std = new Student();

		std.name = "홍길동";
		std.id = 210323;
		std.className = "프레임워크기반자바개발자";

		System.out.println("이름 : " + std.name);
		System.out.println("번호 : " + std.id);
		System.out.println("과정명 : " + std.className);

		std.study("JAVA");
		std.rest();

		System.out.println("-------------------------------");

		Student std2 = new Student();

		std2.name = "김다현";
		std2.id = 210812;
		std2.className = "프레임워크기반자바개발자";

		System.out.println("이름 : " + std2.name);
		System.out.println("번호 : " + std2.id);
		System.out.println("과정명 : " + std2.className);

		std2.study("JAVA");
		std2.rest();

	}

}

//하나의 java 파일 내에 여러개의 클래스 정의 가능

//public class student { }
//=> 오류! The public type Student must be defined in its own file
//=> 파일명과 동일한 이름의 클래스 외에는 public 키워드 사용 불가

class Student {

	String name, className;
	int id;

	public void study(String subjectName) {
		System.out.println(subjectName + " 과목 공부");
	}

	public void rest() {
		System.out.println("휴식");
	}

}
