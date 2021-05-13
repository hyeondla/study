
public class Ex2 {

	public static void main(String[] args) {

		SpiderMan sm = new SpiderMan();
		SpiderMan sm2 = new SpiderMan("파커", 17, true);
		
		
	}

}

class Person {
	
	String name;
	int age;
	
	public Person() {}
	
	public Person(String name, int age) {
		super(); // Object() 호출
		this.name = name;
		this.age = age;
		System.out.println("Person(String, int) 생성자 호출");
	}
	
}

class SpiderMan extends Person {
	
	boolean isSpiderMode;
	
	public SpiderMan() {
		//super(); 
		//슈퍼클래스에 기본 생성자가 없음
		//=> 슈퍼클래스에서 기본 생성자 별도 정의
		//=> 서브클래스에서 슈퍼클래스의 파라미터 생성자를 명시적으로 호출
//		super("피터", 16); // super() this() 동시 사용 불가능
		this("피터", 26, true);
		System.out.println("SpiderMan() 생성자 호출");
//		super("피터", 16);  //오류! 반드시 생성자의 첫 문장에서 실행 
		
	}
	
	public SpiderMan(String name, int age, boolean isSpiderMode) {
		super(name, age); 
		this.isSpiderMode = isSpiderMode;
		System.out.println("SpiderMan(String, int, boolean) 생성자 호출");
	}
	
}