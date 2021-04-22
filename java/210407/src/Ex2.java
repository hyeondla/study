
public class Ex2 {

	public static void main(String[] args) {
		
		//if문
		
		System.out.println("프로그램 시작!");
		
		int num = 14;
		
		if(num < 5) {
			System.out.println("num이 5보다 작다");
		}
				
		System.out.println("프로그램 종료!");
		
		System.out.println("=========================");
		
		int num2 = -5;
		
		if(num2 < 0) {
			num2 = -num2;
			System.out.println("음수를 양수로 변환");
		}
		
		System.out.println("num2의 절대값 : " + num2);
		
	}

}
