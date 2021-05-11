
public class Ex {

	public static void main(String[] args) {
		
		Child c = new Child();
		
		c.childPrn();
		
		c.num = 10; //상속받은 멤버변수
		c.parentPrn(); //상속받은 메서드
		
		c.showNum();
		
		System.out.println("============================");
		
		아버지 아버지 = new 아버지();
		System.out.println("아버지의 자동차 : " + 아버지.자동차);
		아버지.노래하기();
		System.out.println("아버지의 집 : " + 아버지.집);
		아버지.그림그리기();
		
		나 나 = new 나();
		System.out.println("나의 스마트폰 : " + 나.폰);
		나.글쓰기();
		//아버지 클래스 상속
		System.out.println("나의 자동차 : " + 나.자동차);
		나.노래하기();
		//할아버지 클래스 상속
		System.out.println("나의 집 : " + 나.집);
		나.그림그리기();

	}

}

class Parent {
	
	int num;
	
	public void parentPrn() {
		System.out.println("슈퍼클래스의 parentPrn()");
	}
	
}

class Child extends Parent {
	
	public void childPrn() {
		System.out.println("서브클래스의 childPrn()");
	}
	
	public void showNum() {
		System.out.println("부모로부터 상속받은 멤버변수 num = " + num);
	}
	
}

//====================================

class 할아버지 {
	
	String 집 = "고층아파트";
	String 티비 = "최신형 티비";
	
	public void 그림그리기() {
		System.out.println("그림을 잘 그림");
	}
	
}

class 아버지 extends 할아버지 {
	
	String 자동차 = "스포츠카";
	
	public void 노래하기() {
		System.out.println("노래를 잘 부름");
	}
	
}

class 나 extends 아버지 {
	
	String 폰 = "최신형 스마트폰";
	
	public void 글쓰기() {
		System.out.println("글을 잘 씀");
	}
	
}
