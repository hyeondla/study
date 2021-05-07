package static_member;

public class Ex3 {

	// 0. Ex클래스가 메모리에 로딩됨
	// 1. static 키워드가 선언된 모든 멤버가 메모리에 로딩됨
	// 2. static 메서드인 check() 호출됨
	// 3. main() 메서드 자동 호출
	// 4. Ex3 인스턴스 생성됨
	// 5. 인스턴스 변수 b가 메모리에 로딩됨

	int b = check("인스턴스변수 b"); // =>④

	static int a = check("정적 변수 a"); // =>①

	public static int check(String str) {
		System.out.println("check() 호출 : " + str);
		return 0;
	}

	public static void main(String[] args) {

		System.out.println("main() 호출"); // =>③

		Ex3 ex = new Ex3();
		System.out.println("Ex3 인스턴스 생성 완료");

	}

	static int c = check("정적 변수 c"); // =>②

}
