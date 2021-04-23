
public class Ex {

	public static void main(String[] args) {
		
		//----------- worker 메소드 호출 --------------
	
		//1. 파라미터 X, 리턴값 X
		System.out.println("방에 불이 켜져있음");
		turnOff();
		System.out.println("==> 불 끄기 완료");
		System.out.println("===========================");
		//리턴값이 없는 메서드는 출력문에 사용 불가
		
		//2. 파라미터 X, 리턴값 O
		System.out.println("심부름 시키기");
//		String result = call();
//		System.out.println("==> " + result);
		System.out.println("==> " + call());
			
	}

	//----------- worker 메소드 정의 --------------
	
	//1. 파라미터 X, 리턴값 X => 리턴타입 : void
	public static void turnOff(){
		System.out.println("=> 방에 가서 불 끄기");
	}
	
	//2. 파라미터 X, 리턴값 O => 리턴타입 : 리턴할 데이터와 일치하는 데이터타입
	public static String call() {
		System.out.println("=> 심부름꾼이 시킨 일을 함");
		
		return "물 배달"; //리터럴 직접 리턴
	}
	
}
