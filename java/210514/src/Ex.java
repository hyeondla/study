
public class Ex {

	public static void main(String[] args) {

//		Parent p = new Parent();
//		p.parentPrn();
		
		System.out.println("-------------------------");
		
		Child c = new Child();
		c.childPrn();
		c.parentPrn();
		
		System.out.println("=========================");
		
		//===================업캐스팅=================
		Parent p; //레퍼런스 변수 선언
		p = c;  //슈퍼클래스 타입 변수 p에 서브클래스 타입 Child 인스턴스 주소 전달
		//=> 서브클래스 Child 타입 인스턴스 -> 슈퍼클래스 Parent 타입으로 형변환 (묵시적 형변환)
		
		p.parentPrn(); //상속된 메서드 접근 가능
//		p.childPrn(); //오류! 서브클래스에서 정의한 메서드 접근 불가
		//=> 슈퍼클래스 타입으로 업캐스팅 후에는 상속된 메서드만 호출 가능
		//=> 참조 영역에 대한 축소
		
		//하나의 슈퍼클래스 타입으로 여러 서브클래스의 인스턴스를 참조 가능
		
		System.out.println("=========================");
		
		//================다운캐스팅==================
		
		Parent p2 = new Parent();
		p2.parentPrn();
		
		Child c2;
//		c2 = new Child();
		
//		c2 = p2; //오류! Type mismatch: cannot convert from Parent to Child
		//슈퍼클래스 -> 서브클래스 자동 형변환 불가
//		c2 = (Child) p2; //강제 형변환
		
//		c2.parentPrn();
//		c2.childPrn();
		
		System.out.println("=========================");
		
		Parent p3 = new Child();
		p3.parentPrn();
//		p3.childPrn(); //오류!
		
		Child c3 = (Child)p3; 
		c3.parentPrn();
		c3.childPrn();
		
	}

}

class Parent {
	
	public void parentPrn() {
		System.out.println("슈퍼클래스의 parentPrn()");
	}
	
}

class Child extends Parent {
	
	public void childPrn() {
		System.out.println("서브클래스의 childPrn()");
	}
	
}