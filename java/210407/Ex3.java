
public class Ex3 {

	public static void main(String[] args) {
		
		//if ~ else문
		int num = -5;

		if(num < 0) {
			System.out.println("음수 ---> 양수로 변환");
			num = -num;
		} else {
			System.out.println("양수 ---> 변환 생략");
		}
		
		System.out.println("num의 절대값 : " + num);
		
		System.out.println("=========================");
		
		int num2 = 10;
		
		if(num2 % 2 == 1) {
			System.out.println("홀수");
		} else {
			System.out.println("짝수");
		}
		
	}

}
