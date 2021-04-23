
public class Test3 {

	public static void main(String[] args) {

		System.out.println(sum(30,70));
		System.out.println("=====================");
		
		System.out.println(cal('+', 5, 3));
		
	}
    
	public static int sum(int a, int b) {
		return a+b;
	}
	
	public static int cal(char op, int num1, int num2) {
		
		int result = 0;
		
		if(op == '+') {
			result = num1 + num2;
		} else if(op == '-') {
			result = num1 - num2;
		} else if(op == '/') {
			result = num1 / num2;
		} else if(op == '%') {
			result = num1 % num2;
		} else if (op == '*') {
			result = num1 * num2;
		} else {
			System.out.println("연산자를 다시 입력해주세요");
		}
		
		return result;
	}
	
}
