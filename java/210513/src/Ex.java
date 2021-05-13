
public class Ex {

	public static void main(String[] args) {

		Child c = new Child();
		System.out.println("우리집 TV : " + c.tv);
		c.watchTV();
		c.watchParentTV();

		System.out.println("=========================");

		ChildClass cc = new ChildClass();
		cc.method();

	}

}

class Parent {

	String home = "부모님의 집";
	String tv = "부모님이 구입한 TV";

	public void watchTV() {
		System.out.println("부모님 집에서 " + tv + " 보기");
	}

}

class Child extends Parent {

	// 슈퍼클래스로부터 상속받은 멤버변수와 동일한 이름의 변수를 선언하면
	// 슈퍼클래스의 멤버변수는 은닉됨
	String tv = "내가 구입한 TV";

	@Override
	public void watchTV() {
		System.out.println("서브클래스에서 오버라이딩 된 watchTV() 메서드");
		System.out.println("독립한 내 집에서 " + tv + " 보기");
	}

	public void watchParentTV() {
		// 오버라이딩으로 은닉된 슈퍼클래스의 멤버는 super를 통해 접근, 사용
		System.out.println("부모님댁 TV : " + super.tv);
		super.watchTV();
	}

}

//==========================================================================

class ParentClass {
	String x = "Parent"; // 슈퍼클래스 멤버변수
}

class ChildClass extends ParentClass {

	String x = "Child"; // 서브클래스 멤버변수

	public void method() {

		String x = "method"; // 서브클래스 메서드 멤버변수

		System.out.println("x = " + x); // 로컬변수
		//=> 로컬변수를 선언하지 않은 경우 this.x와 동일
		System.out.println("x = " + this.x); // 클래스 멤버변수
		//=> Child 클래스 멤버변수를 선언하지 않은 경우 super.x와 동일
		System.out.println("x = " + super.x); // 슈퍼클래스 멤버변수
		//=> Parent 클래스 멤버변수를 선언하지 않은 경우 오류!
		//   Parent 클래스의 슈퍼클래스인 Object 클래스에 멤버변수 x가 존재하지 않음
		
	}

}