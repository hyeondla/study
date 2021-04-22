
public class Ex2 {

	public static void main(String[] args) {
		
		//반복문을 사용한 연산의 누적
		
		int total = 0;
		for(int i=1; i<11; i++) {
			total += i;
			System.out.println("i = " + i + ", total = " + total);
		}
		System.out.println("정수 합 = " + total);
		
		
	}

}
