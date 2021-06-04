package exception;

public class Ex {

	public static void main(String[] args) {
		
		try {
			팀장();
		} catch (Exception e) {
			System.out.println("사장이 모든 예외 처리");
		}
		
	}
	
	public static void 팀장() throws Exception {
//		try {
//			대리();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (RuntimeException e) {
//			e.printStackTrace();
//		}
		
		대리();
		
	}
	
	public static void 대리() throws RuntimeException, ClassNotFoundException {
//		try {
//			사원();
//			사원2();
//		} catch (ArithmeticException e) {
//			System.out.println("대리가 사원의 ArithmeticException 예외 직접 처리");
//		} catch (NullPointerException e) {
//			System.out.println("대리가 사원의 NullPointerException 예외 직접 처리");
//		} catch (ClassNotFoundException e) {
//			System.out.println("대리가 사원의 ClassNotFoundException 예외 직접 처리");
//		}
		
		사원();
		사원2();
	}
	
	public static void 사원() throws ArithmeticException, NullPointerException {
		//예외처리 1. 예외가 발생한 곳에서 try ~ catch로 직접 예외 처리
//		try {
//			System.out.println("사원에서 예외 발생");
//			System.out.println(3 / 0);
//		} catch (ArithmeticException e) {
//			System.out.println("사원이 직접 예외 처리");
//		} 
		
		System.out.println("사원에서 예외 발생");
		System.out.println(3 / 0);
		
		String str = null;
		System.out.println(str.length());
	}
	
	//예외처리 2. throws로 메서드를 호출한 곳으로 예외를 위임 
	public static void 사원2() throws ClassNotFoundException {
		System.out.println("사원에서 예외 발생");
		Class.forName("");
		//=> Compile Checked Exception
	}
	
}
