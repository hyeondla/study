package bit_operator;

public class Ex2 {

	public static void main(String[] args) {
		
		// 비트 단위 쉬프트 연산자
		// <<, >>
		
		System.out.println("1 << 1 = " + (1<<1));
		System.out.println("1 << 2 = " + (1<<2));
		System.out.println("1 << 3 = " + (1<<3));
		System.out.println("1 << 3 = " + (1<<30));
		System.out.println("1 << 3 = " + (1<<31)); //부호화비트 1 -> 음수
		System.out.println("1 << 3 = " + (1<<32)); //원래 숫자
		System.out.println("1 << 3 = " + (1<<33)); //맨 좌측 탈락하는 비트 -> 맨 우측으로 
		
		// n << x = n*2^x 
		
		System.out.println("------------------------");
		
		System.out.println("10 >> 1 = " + (10>>1));
		System.out.println("10 >> 2 = " + (10>>2));
		System.out.println("10 >> 3 = " + (10>>3));
		System.out.println("10 >> 4 = " + (10>>4)); //0
		System.out.println("10 >> 5 = " + (10>>5)); //0 맨 우측 탈락하는 비트 -> 버려짐
		
		// n >> x = n*(1/2)^x
		
	}

}
