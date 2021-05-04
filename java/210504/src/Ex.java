
public class Ex {

	public static void main(String[] args) {

		NormalArguments na = new NormalArguments();
		na.print("홍길동", "강감찬", "이순신");

		String[] strArr = { "홍길동", "강감찬", "이순신", "김태희" };
		na.print(strArr);

		System.out.println("==========================================");

		VariableArguments va = new VariableArguments();
		va.print("홍길동");
		va.print("홍길동", "강감찬", "이순신");
		va.print();
		va.print(strArr);

		// 가변인자 조합
		va.print2(10, "홍길동", "이순신");

	}

}

class VariableArguments {
	// 가변 인자를 사용한 메서드 오버로딩
	// 가변 인자를 사용한 메서드의 대표적인 예 : printf()
	public void print(String... names) {
		// ... => 0~무한대로 전달 받을 수 있음
		// 가변인자를 사용한 변수 names는 String[] 타입으로 사용됨
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + " ");
		}
		System.out.println();
	}

	public void print2(int num, String... names) {
	}
	// 다른 파라미터와 가변 인자 조합 가능
	// => int형 데이터 1개, 문자열 데이터 여러개 전달 가능

//	public void print2(String...names, int num) {}
//	public void print2(int...num, String...names) {}
	// 오류! 가변인자는 마지막 파라미터로 단 한번만 가능

}

class NormalArguments {
	// 가변 인자를 사용하지 않은 메서드 오버로딩
	public void print(String name1) {
		System.out.println(name1);
	}

	public void print(String name1, String name2) {
		System.out.println(name1 + " " + name2);
	}

	public void print(String name1, String name2, String name3) {
		System.out.println(name1 + " " + name2 + " " + name3);
	}

	// 파라미터로 String 타입 배열 선언
	public void print(String[] names) {
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + " ");
		}
		System.out.println();
	}

}
