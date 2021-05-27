package wrapper_class;

public class Ex4 {

	public static void main(String[] args) {

		int num1 = 10, num2 = 20;
		Integer n1 = 10, n2 = 20;
		
		System.out.println(Integer.max(num1, num2));
		System.out.println(Integer.max(n1, n2));
		
		System.out.println(Integer.min(num1, num2));
		System.out.println(Integer.min(n1, n2));
		
		//Binary(2), Octal(8), Hex(16)
		System.out.println("정수 10 -> 2진수 : " + Integer.toBinaryString(num1));
		System.out.println("정수 10 -> 8진수 : " + Integer.toOctalString(num1));
		System.out.println("정수 10 -> 16진수 : " + Integer.toHexString(num1));
		
		System.out.println("============================================");

		char ch = 'A';
		System.out.println("원본 문자 데이터 : " + ch);
		
		/*
		if(ch >= 'A' && ch <='Z') {
			System.out.println("대문자");
		} else if(ch >= 'a' && ch <= 'z') {
			System.out.println("소문자");
		} else if(ch >= '0' && ch <= '9') {
			System.out.println("숫자");
		} else {
			System.out.println("기타");
		}
		*/
		
		if(Character.isUpperCase(ch)) {
			System.out.println("대문자 -> 소문자 : " + Character.toLowerCase(ch));
		} else if(Character.isLowerCase(ch)) {
			System.out.println("소문자 -> 대문자 : " + Character.toUpperCase(ch));
		} else if(Character.isDigit(ch)) {
			System.out.println("숫자");
		} else {
			System.out.println("기타");
		}
		
		
		
		
	}

}
