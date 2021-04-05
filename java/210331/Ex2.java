
public class Ex2 {

	public static void main(String[] args) {

		char ch = 'A';
		System.out.println(ch);
		
//		ch = ''; //반드시 1개 문자 포함
		ch = ' '; //공백 가능
				
		ch = 65; //=> A
		
		ch = '\u0041'; //=> 16진수 0041 = 10진수 65 = A
		
		System.out.println(ch);
		
		ch = '가';
		ch = '\uAC00';
		System.out.println(ch);
		
		String str = ""; //널스트링
		System.out.println(str);
		
		str = "A"; // != char 타입 'A'
		System.out.println(str);
		
	}

}
