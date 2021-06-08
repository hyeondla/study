package nested_class;

public class Ex2 {

	public static void main(String[] args) {
		
	}

}

class Outer2 {
	private int num = 10; // 인스턴스 멤버변수
	
	public void method() {
		System.out.println(num);
		
//		LocalInner li = new LocalInner(); // 오류
		
		// 로컬 내부클래스
		// => 메서드 내에서 정의, 특정메서드에서만 사용 가능
		class LocalInner {
			String name = "LocalInnerClass";
			
			public LocalInner() {
				System.out.println("LocalInner() 생성자 호출");
			}
		}
		
		LocalInner li = new LocalInner();
		System.out.println(li.name);
		
	}

}