package static_member;

public class Ex4 {

	public static void main(String[] args) {
		
		//싱글톤 디자인 패턴
		//단 하나의 유일한 인스턴스만을 생성하여 공유
		//외부에서 인스턴스 생성을 하지 못하도록 차단
		
		//클래스 내에서 직접 인스턴스를 생성 후 외부로 리턴
		
//		SingletonClass sc = new SingletonClass();
		
		SingletonClass sc = SingletonClass.getInstance(); 
		
//		SingletonClass.instance = null;
		
		sc.str = "싱글톤 패턴으로 생성한 인스턴스의 str";
		
		SingletonClass sc2 = SingletonClass.getInstance();
		
		System.out.println("sc.str : " + sc.str);
		System.out.println("sc2.str : " + sc2.str);
		
		if(sc == sc2) {
			System.out.println("sc와 sc2는 같은 인스턴스");
		} else {
			System.out.println("sc와 sc2는 다른 인스턴스");
		}
		
	}

}

class SingletonClass {
	
	String str;
	
	private SingletonClass() {}
	//=> 생성자에 private 접근제한자 선언
	
	private static SingletonClass instance = new SingletonClass();
	//=> 자신의 클레스 내에서 인스턴스를 직접 생성 후 참조변수에 저장
	//=> 인스턴스 생성 없이 접근해야하므로 static 선언
	//=> 외부에서 멤버변수에 접근하지 못하도록 private 접근제한자 선언

	public static SingletonClass getInstance() { // 리턴타입 : 클래스명
		return instance;  //주소 리턴
	}
	
}

// 코드 작성 순서
class SingletonClass2 {
	
	//1. 인스턴스 생성하여 자신의 클래스 타입 변수 instance에 저장
	//   => private static 제한자
	private static SingletonClass2 instance = new SingletonClass2();
	
	//2. 기본 생성자 정의 
	//   => private 선언
	private SingletonClass2() {}

	//3. Getter 정의 (단축키 -> 자동 생성)
	//   => public static
	public static SingletonClass2 getInstance() {
		return instance;
	}
	
}

