
public class Ex2 {

	public static void main(String[] args) {
		
		int a = 10, b = 5;
		
		System.out.println("a > b : " + (a > b));
		System.out.println("a >= b : " + (a >= b));
		System.out.println("a <= b : " + (a <= b));
		System.out.println("a < b : " + (a < b));
		System.out.println("a == b : " + (a == b));
		System.out.println("a != b : " + (a != b));
		
		boolean result = a > b;
		System.out.println(result);

		System.out.println("==============================");
		
		System.out.println('A'>'B'); //유니코드값 비교 
		System.out.println('A' == 65);
		
		System.out.println(0.1 == 0.1F); //false
		System.out.println((float)0.1 == 0.1F); //true

		System.out.println("==============================");
		
		System.out.println(a + b > a - b);
		
		
		
	}

}
