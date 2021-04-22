
public class Ex {
	
	public static void main(String[] args) {
		
		int a = 10;
		int b;
		
		b = a;
		
		System.out.println(a);
		System.out.println(b);
		
		System.out.println("=======================");
		
		//확장 대입연산자
		
		b += a; //b = b + a
	 	System.out.println(b);
		
		b -= a; //b = b - a
		System.out.println(b);
		
		b *= a; //b = b * a
		System.out.println(b);
		
		b /= a; //b = b / a
		System.out.println(b);
		
		b %= a; // b = b % a
		System.out.println(b);

		System.out.println("=======================");
		
		byte b1 = 10;
//		b1 = b1 + 10; // byte + int = int + int => int
		b1 = (byte) (b1 + 10); //=> byte 형변환 필요
		
		b1 += 10; //자동형변환이 일어나지 않음
		
		System.out.println("=======================");
		
		char ch = 'A';
		
		ch = (char) (ch + 3);
		System.out.println(ch);
		
		ch += 3;
		System.out.println(ch);
		
		
	}

}
