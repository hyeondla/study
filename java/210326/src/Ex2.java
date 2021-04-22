
public class Ex2 {

	public static void main(String[] args) {

		//변수 선언
		int a; //int형 데이터를 저장할 공간 생성, 이름 a로 지정
		
		//변수 초기화 => 반드시 변수 선언 후에 초기화 가능 (a cannot be resolved to a variable)
		a = 10; //int형 변수 a에 정수형 리터럴 10 저장
		
		//변수 출력 => 반드시 초기화 후에 접근 가능 (The local variable a may not have been initialized)
		System.out.println(a);
		
		//변수에 새로운 값 저장 -> 기존 값 제거
		a = 99;
		System.out.println(a);
		
	}

}
