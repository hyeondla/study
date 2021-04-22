
public class Test2 {

	public static void main(String[] args) {
		
		int total = 0;
		for(int i=1; i<=10; i++) {
			if(i%2 == 0) {
				total += i;
				System.out.println("i = " + i + ", total = " + total);
			} else {
				System.out.println("i = " + i + ", 홀수 -> 누적 X");
			}
		}
		System.out.println("짝수인 정수 합 = " + total);
		
		System.out.println("==================================");
		
		total = 0;
		for(int i=1; i<=10; i++) {
			if(i%2 == 1) {
				total += i;
				System.out.println("i = " + i + ", total = " + total);
			} else {
				System.out.println("i = " + i + ", 짝수 -> 누적 X");
			}
		}
		System.out.println("홀수인 정수 합 = " + total);
		
		System.out.println("==================================");
		
		int oddTotal = 0, evenTotal = 0;
		for(int i=1; i<=10; i++) {
			if(i%2 == 0) {
				evenTotal += i;
			} else {
				oddTotal += i;
			}
		}
		System.out.println("짝수 합 = " + evenTotal);
		System.out.println("홀수 합 = " + oddTotal);
		
	}

}
