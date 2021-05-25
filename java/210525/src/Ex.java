
public class Ex {

	public static void main(String[] args) {

		//인터페이스
//		MyExInterface.
		
//		MyExInterface me = new MyExInterface(); //인스턴스 생성 불가
		
		MySubClass msc = new MySubClass();
		msc.method1();
		msc.method2();
		msc.method3();
		
//		MyExInterface.NUM1 = 99; //변경 불가
//		MySubClass.NUM1 = 99; //변경 불가
//		msc.NUM1 = 99; //변경 불가
		
		System.out.println("=======================================");
		
		MyExInterface mi = new MySubClass(); //업캐스팅
		mi.method1();
		mi.method2();
		mi.method3();
		
		System.out.println(MyExInterface.NUM1);
		System.out.println(MyExInterface.NUM2);
		
	}

}

class MySubClass implements MyExInterface {

	@Override
	public void method1() {
		System.out.println("서브클래스에서 구현한 추상메서드 method1()");
	}

	@Override
	public void method2() {
		System.out.println("서브클래스에서 구현한 추상메서드 method2()");		
	}

	@Override
	public void method3() {
		System.out.println("서브클래스에서 구현한 추상메서드 method3()");
	}
	
}

interface MyExInterface {
	
	public static final int NUM1 = 10;
	int NUM2 = 20; //상수
	
	public abstract void method1();
//	public void method2() {}; //메서드 바디 X
	public void method2(); 
	void method3(); 
	
}

abstract class MyClass {
	
	public static final int NUM1 = 10; //상수
	public int num2 = 20; //인스턴스 멤버변수
	
	public MyClass() {} //생성자
	
	public abstract void method1(); //추상메서드
	public void method2() {} //일반메서드
}
