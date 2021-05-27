package wrapper_class;

public class Ex2 {

	public static void main(String[] args) {

		int num1 = 10;
		int num2;
		
		System.out.println("기본타입 변수 num1의 값 = " + num1); //저장된 정수데이터 출력
		
		Integer n1;
//		Integer n2 = new Integer(20);	//인스턴스 생성 -> 주소값을 참조변수 n2에 저장
		Integer n2 = new Integer("20");	//문자열 -> 정수 변환
		
		System.out.println("참조타입 변수 n2의 값 = " + n2); 
		//주소값이 출력되어야하지만 Wrapper 클래스에는 toString() 메서드 오버라이딩 되어있음
		//=> 객체가 저장한 값을 문자열로 리턴 => 데이터가 출력됨
 		
		
		System.out.println("--------------------------------------------");
		
		//기본데이터타입 -> Stack에 실제 데이터 직접 관리
		//참조데이터타입 -> Heap에 실제 데이터 저장, 해당 주소값을 Stack에서 관리
		//기본타입과 참조타입은 호환 불가 -> 메서드 사용
//		n1 = Integer.valueOf(num1);
//		System.out.println(num1 + " " + n1);
		
		//Java 1.5 부터 기본형 -> Wrapper 자동 변환 수행 (오토박싱)
		//				Wrapper -> 기본형 자동 변환 수행 (오토언박싱)
		//대입연산자를 통해 직접 대입 가능
		n1 = num1;
		System.out.println(num1 + " " + n1);
		
//		num2 = n2.intValue();
//		System.out.println(num2 + " " + n2);
		
		num2 = n2;
		System.out.println(num2 + " " + n2);
		
		System.out.println("--------------------------------------------");
		
		int num3 = 10;
		Integer n3 = 20;
		
		System.out.println(num3 + n3); //오토언박싱 후 연산
		
		System.out.println("--------------------------------------------");
		
		//Object 타입 변수에 기본 데이터타입 저장 가능
		//기본 데이터타입 -> Wrapper 클래스 타입 (오토박싱) -> Object 타입 (업캐스팅)
		Object o = 10;
		System.out.println(o); //toString() 생략
		
	}

}
