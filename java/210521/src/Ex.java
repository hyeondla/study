
public class Ex {

	public static void main(String[] args) {
		
//		AbstractClass ac = new AbstractClass();
		//=> 오류! Cannot instantiate the type AbstractClass
		//추상클래스는 인스턴스 생성 불가
		
		SubClass sc = new SubClass();
		sc.normalMethod();
		sc.abstractMethod();
		sc.subclassMethod();
		
		//추사읔ㄹ래스를 참조변수 타입으로 활용 가능
		AbstractClass ac = new SubClass(); //업캐스팅 -> 다형성
		ac.normalMethod();
		ac.abstractMethod();
//		ac.subclassMethod(); //=> 오류! 참조영역의 축소로 보이지않는 메서드
		
		System.out.println("=====================================");
		
		SuperMan sm = new SuperMan();
		sm.takeOff();
		sm.fly();
		sm.land();
		
		Bird b = new Bird();
		b.takeOff();
		b.fly();
		b.land();
		
		Airplane ap = new Airplane();
		ap.takeOff();
		ap.fly();
		ap.land();
		
		System.out.println("---------------------------------------");
		
		Flyer f = new SuperMan();
		f.takeOff();
		f.fly();
		f.land();
		
		f = new Bird();
		f.takeOff();
		f.fly();
		f.land();
		
		f = new Airplane();
		f.takeOff();
		f.fly();
		f.land();
		
	}

}

abstract class AbstractClass {
//=> 오류! The abstract method can only be defined by an abstract class
	
	//public abstract void abstractMethod() {}
	//=> 오류! Abstract methods do not specify a body
	
	public abstract void abstractMethod(); //추상 메서드
	
	public void normalMethod() {} //일반 메서드
	public AbstractClass() {} //생성자
	String member; //멤버변수
	
}

class SubClass extends AbstractClass {
//=> 오류! The type SubClass must implement the inherited abstract method

	@Override
	public void abstractMethod() {
		System.out.println("서브클래스에서 오버라이딩(구현)된 추상메서드");
	}
	
	public void subclassMethod() {
		System.out.println("서브클래스에서 정의한 메서드");
	}
	
}

abstract class Flyer {
	
	public abstract void takeOff();
	public abstract void fly();
	public abstract void land();
	
}

class SuperMan extends Flyer {

	@Override
	public void takeOff() {
		System.out.println("슈퍼맨 이륙");
	}
	@Override
	public void fly() {
		System.out.println("슈퍼맨 비행");
	}
	@Override
	public void land() {
		System.out.println("슈퍼맨 착륙");
	}
	
}

class Bird extends Flyer {

	@Override
	public void takeOff() {
		System.out.println("새 이륙");
	}
	@Override
	public void fly() {
		System.out.println("새 비행");
	}
	@Override
	public void land() {
		System.out.println("새 착륙");
	}
	
}

class Airplane extends Flyer {

	@Override
	public void takeOff() {
		System.out.println("비행기 이륙");
	}
	@Override
	public void fly() {
		System.out.println("비행기 비행");
	}
	@Override
	public void land() {
		System.out.println("비행기 착륙");
	}
	
}