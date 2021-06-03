package exception;

public class Ex2 {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		try {
//			String str = null;
			String str = "";
			System.out.println(str.length());
			System.out.println("try 블록 끝");
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("NullPointerException 예외 처리");
		} finally {
			System.out.println("finally - 예외 발생 여부와 관계없이 실행");
		}
		
		System.out.println("프로그램 종료");
		
		System.out.println("--------------------------------------------");
		
		method1(); 
		
	}

	public static void method1() {
		
		System.out.println("프로그램 시작");
		
		try {
//			String str = null;
			String str = "";
			System.out.println(str.length());
			System.out.println("try 블록 끝");
			return; //=> finally 블록이 존재할 경우 실행 후 돌아감
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("NullPointerException 예외 처리");
		} finally {
			System.out.println("finally - 예외 발생 여부와 관계없이 실행");
		}
		
		System.out.println("프로그램 종료");
		
	}
	
}
