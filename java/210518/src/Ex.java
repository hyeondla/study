
public class Ex {

	public static void main(String[] args) {

		Parent p = new Parent();
		p.parentPrn();
		
		Child c = new Child();
		c.childPrn();
		c.parentPrn();
		
		System.out.println("-----------------------------------");
		
		p = c; //child->parent
		p.parentPrn();
		
	}

}

class Parent {
	
	public void parentPrn() {
		System.out.println("슈퍼클래스 parentPrn()");
	}
	
}

class Child extends Parent {
	
	public void childPrn() {
		System.out.println("서브클래스 childPrn()");
	}

	@Override
	public void parentPrn() {
		System.out.println("서브클래스에서 오버라이딩한 parentPrn()");
	}
	
	
}