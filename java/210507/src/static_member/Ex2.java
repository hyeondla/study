package static_member;

public class Ex2 {

	public static void main(String[] args) {

		StaticMethod.staticMethod();
		
		StaticMethod sm = new StaticMethod();

		sm.normalMethod();
//		sm.staticMethod();
		StaticMethod.staticMethod();

	}

}

class StaticMethod {

	int normalVar = 10;
	static int staticVar = 20;
	
	public void setNormalVar(int normalVar) {
		this.normalVar = normalVar;
	}
	public static void setStaticVar(int staticVar) {
		StaticMethod.staticVar = staticVar;
	}
	

	public void normalMethod() {
		System.out.println("일반메서드 normalMethod()");
		
		System.out.println("일반메서드에서 인스턴스 변수 접근 : " + normalVar);
		System.out.println("일반메서드에서 정적 변수 접근 : " + staticVar);
		staticMethod();
	}

	public static void staticMethod() {
		System.out.println("정적메서드 staticMethod()");

//		System.out.println("정적메서드에서 인스턴스 변수 접근 : " + normalVar);
		//오류! Cannot make a static reference to the non-static field normalVar
		//=> 인스턴스 변수는 메모리에 로딩되기 전이므로 접근 불가
		System.out.println("정적메서드에서 정적 변수 접근 : " + staticVar);
		
		//메서드 오버라이딩 불가
		
	}
	
	

}
