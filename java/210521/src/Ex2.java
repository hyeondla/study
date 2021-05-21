
public class Ex2 {

	public static void main(String[] args) {

	}

}

abstract class AbstractClass2 {
	public abstract void method1();
	public abstract void method2();
}

abstract class MiddleClass extends AbstractClass2 {

	@Override
	public void method1() {
		System.out.println("MiddleClass에서 구현한 method1()");
	}
	
}

class SubClass2 extends MiddleClass {

	//method1() 이미 구현되어있으므로 선택적
	
	@Override
	public void method2() { //강제성
		System.out.println("SubClass2에서 구현한 method2()");
	}
	
}