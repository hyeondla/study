
public class Ex {

	public static void main(String[] args) {

		//if ~ else if ~ else 문
		//조건식의 범위가 좁은 것부터 판별해야함
		
		int num = -20;
		
		if(num > 0) {
			System.out.println(num + " : 양수");
		} else if(num < 0) {
			System.out.println(num + " : 음수");
		} else {
			System.out.println(num + " : 0");
		}
		
		System.out.println("----------------------------");
		
		num = 9;
		
		if(num % 2 == 1) {
			System.out.println(num + " : 홀수");
		} else if(num == 0) {
			System.out.println(num + " : 0");
		} else {
			System.out.println(num + " : 짝수");
		}
		
		System.out.println("----------------------------");
		
		num = 7;
		
		if(num > 10) {
			System.out.println(num + " : 10보다 크다");
		} else if (num > 5) {
			System.out.println(num + " : 5보다 크다");
		}

	

	}
}
