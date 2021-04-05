
public class Ex2 {

	public static void main(String[] args) {

		byte b1 = 10, b2 = 20, b3;
		
		System.out.println(b1 + b2);
		
		//byte + byte -> 자동 형변환 -> int + int -> int
//		b3 = b1 + b2; //오류 => int 타입을 byte 타입으로 저장하려면 강제 형변환 필요
//		b3 = (byte)b1 + (byte)b2; //오류 => 다시 각각 int로 변환되어 연산
		//=> 연산 결과를 형변환
		b3 = (byte)(b1 + b2); 
		System.out.println(b3);
		
//		short s = b1 + b2;
		short s = (short)(b1 + b2);
		System.out.println(s);
		
		System.out.println("=============================");	
		
		char ch = 'A';
//		char ch2 = ch + 2; //=> char + int -> int + int -> int
		char ch2 = (char) (ch + 2);
		System.out.println(ch2);
		System.out.println(ch + 2); //67
		System.out.println((char)(ch + 2)); //C
		
		System.out.println("=============================");	
		
		int i = 100;
		long l = 200L;
		
//		int i2 = i + l;
		long i2 =  i + l;
		System.out.println(i2);
		
		float f = 3.14F;
		long l2 = (long)(l + f);
		System.out.println(l2);
		
		System.out.println("=============================");	
		
		System.out.println(3 / 2); //-> int / int -> int 1 
		//=> 최소한 피연산자 중 하나를 실수로 변환 후 계산
		
		System.out.println((double)3 / 2); //double
		System.out.println(3 / 2.0); //.0 붙이기
//		System.out.println(3 / 2D); 
		
		System.out.println("=============================");	
		
		float f1 = 0.1F;
		double d1 = 0.1;
		
		System.out.println(f1);
		System.out.println(d1);
		
		System.out.println(f1 + d1); //0.20000000149011612
		//=> float + double -> double + double -> double 
		//   근사치 표현에 의해 잘못된 결과 발생 가능
		//   => double -> float 강제변환 
		System.out.println(f1 + (float)d1); //0.2
		
		System.out.println( ((int)(f1 * 10) + (int)(d1 * 10)) / 10.0 );
		//=>모두 정수로 변환하여 연산 수행 후 실수로 변환

		System.out.println("=============================");	
		
		byte b4 = 10 + 20; //리터럴끼리 연산시 자동 형변환 X
//    byte b5 = 10 + 200; //표현 가능 범위를 초과하면 오류 
		System.out.println(b4);
		
		
		
		
		
	}

}
