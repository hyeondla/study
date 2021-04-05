
public class Ex3 {

	public static void main(String[] args) {

		//byte <-> char 명시적 형변환 필수
		
		byte b = 100;
		short s = 65;
		
		char ch;
		
		//byte -> char
//		ch = b; //오류
		ch = (char) b;
		System.out.println(ch);
		
		//char -> byte
//		b = ch; //오류
		b = (byte) ch;
		System.out.println(b);
		
		System.out.println("============================");
		
		//short <-> char 명시적 형변환 필수
		
		//short -> char
//		ch = s; //오류
		ch = (char) s;
		System.out.println(ch);
		
		//char -> short
//		s = ch; //오류
		s = (short) ch;
		System.out.println(s);
		
		System.out.println("============================");
		
		// int <- char 자동 형변환
		
		int i = ch;
		System.out.println(i);
		
	}

}
