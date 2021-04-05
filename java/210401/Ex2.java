
public class Ex2 {

	public static void main(String[] args) {

		int a1 = 32768;
		short a2 = 32767;
		
		System.out.printf("a1(int) : %d, a2(short) : %d\n", a1, a2);
		
		a1 = a2; //자동 형변환
		System.out.printf("a1(int) : %d, a2(short) : %d\n", a1, a2);
		
		System.out.println("==========================================");
		
		int b1 = 32768;
		short b2 = 32767;
		
		System.out.printf("b1(int) : %d, b2(short) : %d\n", b1, b2);
	
//		b2 = b1; //오류 발생 => 오버플로우, 큰 데이터타입을 작은 데이터타입으로 이동할 때 자동 형변환 X
		b2 = (short) b1; //형변환 연산자를 통해 작은 타입 명시
		System.out.printf("b1(int) : %d, b2(short) : %d\n", b1, b2);
		//강제 형변환 -> 오버플로우 발생 가능 -> 저장된 데이터가 원본 데이터와 다를 수 있음 
		System.out.println("==========================================");
		
		int c1 = 100;
//		short c2 = c1; //오류
		short c2 = (short) c1;
		System.out.printf("c1(int) : %d, c2(short) : %d\n", c1, c2);
		//저장 가능한 범위 내의 데이터 -> 명시적 형변환 후에도 오버플로우 X -> 원본 데이터 유지됨
		System.out.println("==========================================");
		
		int d1 = 100;
		double d2 = 3.14;
		System.out.printf("d1(int) : %d, d2(double) : %f\n", d1, d2);
		
		d2 = d1; //자동 형변환
		System.out.printf("d1(int) : %d, d2(double) : %f\n", d1, d2);
		
		System.out.println("==========================================");
		
		int e1 = 100;
		double e2 = 3.14;
		System.out.printf("e1(int) : %d, e2(double) : %f\n", e1, e2);
		
//		e1 = e2; //오류
		e1 = (int) e2; //강제 형변환
		System.out.printf("e1(int) : %d, e2(double) : %f\n", e1, e2);
		
		System.out.println("==========================================");
		
		long l = 100L;
		float f = l; //long -> float 자동 형변환
		
//		l = f; //오류
		l = (long) f; //강제 형변환
		
		
		
		
	}

}
