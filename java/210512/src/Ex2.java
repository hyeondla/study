
public class Ex2 {

	public static void main(String[] args) {
		
		Child c = new Child();
		
		c.childPrn();
		c.parentPrn();
		
		System.out.println("================================================");
		
		SpiderMan2 s = new SpiderMan2();
		s.jump();
		
		System.out.println("================================================");
		
		Dog dog = new Dog();
		dog.cry();
		
		Cat cat = new Cat();
		cat.cry();
		
	}

}

class Parent{
	
	public void parentPrn() {
		System.out.println("슈퍼클래스의 parentPrn()");
	}
	
	public Object parentPrn2() {
		System.out.println("슈퍼클래스의 parentPrn2()");
		return null;
	}
	
	public String parentPrn3() {
		System.out.println("슈퍼클래스의 parentPrn3()");
		return null;
	}
	
}

class Child extends Parent {
	
	public void childPrn() {
		System.out.println("서브클래스의 childPrn()");
	}
	
	public void parentPrn() {
		System.out.println("서브클래스에서 오버라이딩 된 parentPrn()");
	}
	
	//오류! 오버라이딩 시 슈퍼클래스의 접근제한자보다 좁아질 수 없음
//	protected void parentPrn() {
//		System.out.println("서브클래스에서 오버라이딩 된 parentPrn()");
//	}
	
	//오버라이딩 시 슈퍼클래스의 리턴타입(Object) 서브클래스 타입(String)을 명시할 수 있음
	public String parentPrn2() { 
		System.out.println("서브클래스에서 오버라이딩 된 parentPrn2()");		
		return null;
	}

	//오류! 오버라이딩 시 리턴타입은 기존 리턴타입의 슈퍼클래스 타입이 올 수 없음
//	public Object parentPrn3() {
//		System.out.println("서브클래스에서 오버라이딩 된 parentPrn3()");		
//		return null;
//	}
	
	@Override 
	public String parentPrn3() {
		System.out.println("서브클래스에서 오버라이딩 된 parentPrn3()");		
		return null;
	}

}

//=============================================================================

class Person2 {
	
	public void eat() {
		System.out.println("밥먹기");
	}
	
	public void jump() {
		System.out.println("점프하기");
	}

}

class SpiderMan2 extends Person2 {

	public void fireWeb() {
		System.out.println("거미줄 쏘기");
	}

	@Override
	public void jump() {
		System.out.println("10m 높이의 고공 점프");
	}
	
}

//=============================================================================

class Animal {
	
	String name;
	int age;
	
	public void cry() {
		System.out.println("동물 울음 소리");
	}
	
}

class Dog extends Animal {

	@Override
	public void cry() {
		System.out.println("멍멍");
	}
	
}

class Cat extends Animal {

	@Override
	public void cry() {
		System.out.println("야옹");
	}
	
}


