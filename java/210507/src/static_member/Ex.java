package static_member;

public class Ex {

	public static void main(String[] args) {

		// static

		NormalMember n1 = new NormalMember();
		NormalMember n2 = new NormalMember();
		// => 인스턴스 두개 생성, 인스턴스 변수 두개씩 생성

		System.out.printf("n1.a : %d, n2.a : %d\n", n1.a, n2.a);
		System.out.printf("n1.b : %d, n2.b : %d\n", n1.b, n2.b);

		System.out.println("--------------------------------------");

		n1.a = 99;
		n1.b = 999;

		System.out.printf("n1.a : %d, n2.a : %d\n", n1.a, n2.a);
		System.out.printf("n1.b : %d, n2.b : %d\n", n1.b, n2.b);

		System.out.println("======================================");

		System.out.println("StaticMember.a : " + StaticMember.a);
		// => 인스턴스가 생성되기 전이지만 이미 메모리에 로딩되어 있으므로 접근 가능
		System.out.println("--------------------------------------");

		StaticMember s1 = new StaticMember();
		StaticMember s2 = new StaticMember();
		// => 인스턴스 두개 생성, 인스턴스 변수 b는 하나씩 생성
		// => 정적 변수 a는 클래스당 하나만 Method Area에 생성 -> 공유

		System.out.printf("s1.a : %d, s2.a : %d\n", s1.a, s2.a);
		System.out.printf("s1.b : %d, s2.b : %d\n", s1.b, s2.b);

		System.out.println("--------------------------------------");

		s1.a = 99; // => 변경된 값이 공유됨
		s1.b = 999;

		System.out.printf("s1.a : %d, s2.a : %d\n", s1.a, s2.a);
		System.out.printf("s1.b : %d, s2.b : %d\n", s1.b, s2.b);

		System.out.println("--------------------------------------");

		s2.a = 1000;

		System.out.printf("s1.a : %d, s2.a : %d\n", s1.a, s2.a);

		// static 멤버는 클래스명으로 접근 가능
		StaticMember.a = 500;
//		StaticMember.b = 200; //오류!
		System.out.printf("s1.a : %d, s2.a : %d\n", StaticMember.a, StaticMember.a);

		System.out.println("======================================");

		// static 멤버 변수의 대표적인 예 : java.lang.Math 클래스의 PI 변수
		System.out.println("PI 값 : " + Math.PI);

	}

}

class NormalMember {

	int a = 10;
	int b = 20;

}

class StaticMember {

	static int a = 10;
	int b = 20;

}