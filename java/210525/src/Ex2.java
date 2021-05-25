
public class Ex2 {

	public static void main(String[] args) {
		
		고래상어 고래상어 = new 고래상어();
		고래상어.번식();
		
		동물 동물 = 고래상어;
		동물.번식();
		
		
	}

}

interface 동물 {
	public abstract void 번식();
}

interface 헤엄칠수있는 {
	
}

//인터페이스끼리 상속 -> extends
interface 고래 extends 동물, 헤엄칠수있는 {}
interface 상어 extends 동물, 헤엄칠수있는 {}

class 고래상어 implements 고래, 상어 {

	@Override
	public void 번식() {
		System.out.println("알 낳기");
	}
	
}




//다이아몬드 상속 문제점
/*
 
abstract class 동물 {
	public abstract void 번식();
}

class 고래 extends 동물 {
	@Override
	public void 번식() {
		System.out.println("새끼");
	}
}

class 상어 extends 동물 {
	@Override
	public void 번식() {
		System.out.println("알");
	}
}

class 고래상어 extends 고래, 상어 { //다중 상속 불가
	
}

*/