
public class Ex {

	public static void main(String[] args) {
		
		//삼항연산자 
		// 조건식 ? 값1(true) : 값2(false)
		
		int num = -5;
		
		System.out.println(num >= 0);
		System.out.println(num >= 0 ? "양수" : "음수");
		
		String result = num >= 0 ? "양수" : "음수";
		System.out.println(result);
		
		System.out.println("===============================");
		
		result = num > 0 ? "양수" : num < 0 ? "음수" : "0";
		System.out.println(result);
		
	}

}
