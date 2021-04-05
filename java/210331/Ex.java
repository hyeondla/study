
public class Ex {

	public static void main(String[] args) {

//		byte b;
//		b = 100;
		byte b = 100;
		System.out.println(b);
		
		b = 127;
//		b = 128; //=> byte -128~127
		b = -128;
		System.out.println(b);
		
		short s = 128;
		System.out.println(s);
		
		s = 32767;
//		s = 32768; //=> short -32768~32767
		
		int i = 32768;
		System.out.println(i);
		
		i = 2147483647;
//		i = 2147483648; 
		
		//정수에 접미사가 없으면 기본적으로 int 사용
		//=> int 번위를 벗어나는 리터럴은 접미사 L 붙여야함
		
//		i = 2147483648L; //long 타입 정수는 int 타입 변수에 저장 X
		
		long l = 2147483648L;
		System.out.println(l);
		
//		i = 5L;
		//int 타입보다 크지 않은 정수도 접미사 L 붙이면 long 타입으로 취급
		
		double d = 3.14; //실수 기본 데이터타입 
		float f = 3.14F; 
		System.out.println(d);
		System.out.println(f);
		
		//boolean => true/false만 사용
		boolean bool = true;
		System.out.println(bool);
		bool = false;
		System.out.println(bool);
		
		System.out.println("====================================");
		
		//10진수
		int num = 10;
		System.out.println(num);
		
		//2진수 => 접두사 0b
		num = 0b1010;
		System.out.println(num);
//		num = 0b1012;
		
		//8진수 => 접두사 0
		num = 012;
		System.out.println(num);
//		num = 018;
		
		//16진수 => 접두사 0x
		num = 0xA;
		System.out.println(num);
		
		
		
		
		
		System.out.println("====================================");
				
		//String => 문자열 저장
		String str = "Hello, World!";
		System.out.println(str);
		
	}

}
