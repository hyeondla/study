
public class Ex {

	public static void main(String[] args) {
		
//		SpiderMan s = new SpiderMan();
//		sm.name = "톰";
		
		SpiderMan s = new SpiderMan("톰", 16, false, true);
		
		s.eat();
		s.jump();
		s.fireWeb();
		
	}

}

class Person {
	
	String name;
	int age;
	boolean isHungry;
	
	public Person() {
		System.out.println("Person() 생성자 호출");
	}
	
	public void eat() {
		System.out.println("밥먹기");
	}
	
	public void jump() {
		System.out.println("점프하기");
	}

}

class SpiderMan extends Person {

	boolean isSpiderMode;
	
	public SpiderMan() {
		System.out.println("SpiderMan() 생성자 호출");
	}
	public SpiderMan(String name, int age, boolean isHungry, boolean isSpiderMode) {
		System.out.println("SpiderMan(String, int, boolean, boolean) 생성자 호출");
		this.name = name;
		this.age = age;
		this.isHungry = isHungry;
		this.isSpiderMode = isSpiderMode;
	}
	
	public void fireWeb() {
		System.out.println("거미줄 쏘기");
	}
	
}