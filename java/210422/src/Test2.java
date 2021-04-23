
public class Test2 {

	public static void main(String[] args) {
		
		print("Hello");
		System.out.println("-------------------");
		
		numberCheck(9);
		System.out.println("===================");
		
		System.out.println(numberCheck2(10));
		
		
		
	}

	public static void print(String str) {
		System.out.println(str);
	}
	
	public static void numberCheck(int num) {
		if(num%2 == 1) {
			System.out.println("홀수");
		} else {
			System.out.println("짝수");
		}
	}
	//========================================
	
	public static String numberCheck2(int num) {
		if(num%2 == 1) {
			return "홀수";
		} else {
			return "짝수";
		}
	}
	
	
	
}
