
public class Ex3 {

	public static void main(String[] args) {

		//switch-case문
		//case문 끼리의 순서는 무관
		
		int num = 2;
		
		switch(num) {
		
			case 1 : System.out.println("num = 1");
			case 2 : System.out.println("num = 2");
			case 3 : System.out.println("num = 3");
			
		}
		
		System.out.println("----------------------------");
		
		num = 2;
		
		switch(num) {
		
			case 1 : System.out.println("num = 1");
			case 2 : System.out.println("num = 2");
			case 3 : System.out.println("num = 3");
			default : System.out.println("일치하는 case문 없음");
			//break문이 없으면 그 아래 case...default 까지 실행
		}
		
		System.out.println("----------------------------");
		
		num = 2;
		
		switch(num) {
		
			case 1 : 
				System.out.println("num = 1"); 
				break;
			case 2 : 
				System.out.println("num = 2"); 
				break;
			case 3 : 
				System.out.println("num = 3"); 
				break;
			default : 
				System.out.println("일치하는 case문 없음");
			
		}
		
		System.out.println("----------------------------");
		
		switch("KOREA") { //변수 대신 값 전달 가능
	
			case "대한민국" : System.out.println("대한민국!"); break;
			case "KOREA" : System.out.println("KOREA!"); break;
			case "한국" : System.out.println("한국!"); break;
			default : System.out.println("다른 나라!");
			
		}
		
		System.out.println("----------------------------");
		
		switch(10 / 2) {} //변수 대신 연산식 사용 가능 => 결과가 정수, 문자열 타입이어야 함
						
	}

}
