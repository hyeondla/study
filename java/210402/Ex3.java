
public class Ex3 {

	public static void main(String[] args) {

		int a = 10, b = 20;
		System.out.println(a + b); //산술연산(덧셈)
		
		System.out.println("a = " + a); //"문자열" + 정수 = "문자열정수"
		
		String str = "a = " + a;
		System.out.println(str);
		
		System.out.println("b = " + b);
		
		int c = a + b;
		System.out.println(a + " + " + b + " = " + c);
		
		System.out.println("덧셈결과 : " + c);
		
		System.out.println("=============================");	
		
		System.out.println(10 + "20"); //1020
		System.out.println(10 + 20); //30
		System.out.println("10" + 20); //1020
		
		System.out.println(10 + "20" + 30); //102030
		System.out.println("10" + 20 + 30); //102030 문자열 결합
		System.out.println(10 + 20 + "30"); //3030 덧셈 먼저 수행 + 문자열 결합
		
		System.out.println("=============================");	
		
		String name = "김다현";
		int age = 28;
		//	int jumin = 9010101234567;
		//	long jumin = 9010101234567L;
		String jumin = "901010-1234567";
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("주민번호 : " + jumin);
		
		
		
		
	}

}
