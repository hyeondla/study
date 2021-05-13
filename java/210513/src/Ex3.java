
public class Ex3 {

	public static void main(String[] args) {

		System.out.println("PI 값 = " + Math.PI);
//		Math.PI = 3.14; //The final field Math.PI cannot be assigned
		
		//final 클래스 상속 불가능, 사용 가능
		String str = new String();
		
	}

}

class FinalMember {
	
	final int finalMember = 10;
	
	//final 상수 초기화하지 않을 경우 오류!
	final int blankFinalMember;
	//=> 생성자를 통해 초기화하는 경우 사용 가능
	public FinalMember(int blankFinalMember) {
		super();
		this.blankFinalMember = blankFinalMember;
		//=> 객체마다 다른 상수 값을 가짐
	}

	public void change() {
//		finalMember = 99; //=> final 변수는 값 변경 불가
		System.out.println(finalMember); //사용 가능
	}
	
}

//---------------------------------------------

class FinalMethod {
	
	public final void finalMethod() {
		System.out.println("슈퍼클래스 finalMethod()");
	}
	
	public void normalMethod() {
		System.out.println("슈퍼클래스 normalMethod()");
	}
	
}

class SubFinalMethod extends FinalMethod {

//	@Override
//	public void finalMethod() { //=> final 메서드 오버라이딩 불가
//		System.out.println("서브클래스에서 오버라이딩 된 finalMethod()");
//	}

	@Override
	public void normalMethod() {
		System.out.println("서브클래스에서 오버라이딩 된 normalMethod()");
		finalMethod(); //호출 가능
	}
	
}

//-----------------------------------------------

final class FinalClass {
	
	int num = 10;
	
	public void method() {
		System.out.println("슈퍼클래스 method()");
	}
	
}

//class SubFinalClass extends FinalClass { //=> final 클래스 상속 불가
//	
//}

class SubFinalClass {
	
	//상속관계(is-a) => 불가
	//포함관계(has-a) => 인스턴스 생성, 사용 가능
	FinalClass fc = new FinalClass(); 
	
}

//---------------------------------------------------

//class SubString extends String {} //The type SubString cannot subclass the final class String
//class SubMath extends Math {} //The type SubMath cannot subclass the final class Math












