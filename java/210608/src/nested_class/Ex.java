package nested_class;

import nested_class.Outer.Inner;

public class Ex {

	public static void main(String[] args) {
		
		Outer outer = new Outer();
		outer.method();
		outer.method2();
		
		System.out.println("--------------------------------------------");
		
//		Inner inner = new Inner(); // 오류!
		Inner inner = outer.new Inner();
//		Outer.Inner inner = outer.new Inner();
		inner.innerMethod();
		System.out.println(inner.innerNum);
		
		System.out.println("--------------------------------------------");
		
		Outer.StaticInner staticInner = new Outer.StaticInner();
		
	}

}

class Outer {
	
	private int num = 10; // 인스턴스 멤버변수
	int num2 = 20;
	static int num3 = 30; // 정적 멤버변수
	
	public void method() { // 인스턴스 멤버메서드
		System.out.println("인스턴스 멤버변수 num = " + num);
		
		method2();
		
		Inner inner = new Inner();
	}
	
	public void method2() {
		System.out.println("인스턴스 메서드 method2()");
	}
	
	public static void method3() { // 정적 멤버메서드
//		System.out.println("인스턴스 멤버변수 num = " + num); // 접근불가
		System.out.println("정적 멤버변수 num3 = " + num3);
	}
	
	//----------------------------------------------------------------------
	
	// 인스턴스 멤버 내부클래스
	class Inner {
		int innerNum = 100;
		
		public void innerMethod() {
			System.out.println("외부클래스 인스턴스 멤버변수 num = " + num);
			method2(); // 외부클래스 인스턴스 멤버메서드
		}
	}
	
	//----------------------------------------------------------------------
	
	// 정적 멤버 내부클래스
	static class StaticInner {
		int innerNum = 100;
		static int innerStaticNum = 200;
		
		public void innerMethod() {
//			System.out.println("외부클래스 인스턴스 멤버변수 num = " + num); // 접근불가
//			method2(); // 접근 불가
			
			System.out.println("외부클래스 정적 멤버변수 num3 = " + num3);
		}
		
		public static void innerStaticMethod() {
//			System.out.println("내부클래스 인스턴스 멤버변수 innerNum = " + innerNum); // 접근불가
			System.out.println("내부클래스 인스턴스 멤버변수 innerNum = " + innerStaticNum);
		}
		
	}
	

}