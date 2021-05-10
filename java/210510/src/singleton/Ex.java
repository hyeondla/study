package singleton;

public class Ex {

	public static void main(String[] args) {

//		SingletonClass sc = new SingletonClass();
		// 오류! The constructor SingletonClass() is not visible
		// => 생성자의 접근제한자 private => 외부에서 인스턴스 생성 불가

		// Getter => 인스턴스 리턴 받기
		SingletonClass sc = SingletonClass.getInstance();

		// 리턴받은 인스턴스를 통해 멤버변수/메서드 접근
		sc.print();

	}

}

class SingletonClass {

	private static SingletonClass instance = new SingletonClass();
	// 데이터타입 변수명 = new 생성자();

	private SingletonClass() {
	}

	public static SingletonClass getInstance() {
		return instance;
	}

	public void print() {
		System.out.println("print() 메서드 호출");
	}

}