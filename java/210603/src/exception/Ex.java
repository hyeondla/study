package exception;

public class Ex {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
//		int num = 0;
//		System.out.println(3 / num); //예외 발생 java.lang.ArithmeticException 
		
//		int[] arr = {1, 2, 3};
//		System.out.println(arr[5]); //예외 발생 java.lang.ArrayIndexOutOfBoundsException
		
//		String str = null;
//		System.out.println(str.length()); //예외 발생 java.lang.NullPointerException
		
		System.out.println("프로그램 종료"); //출력 X
		
		System.out.println("============================================");
		
		//예외 처리
		System.out.println("프로그램 시작");
		
		try {
			int num = 1;
			System.out.println(3 / num); //예외 발생 가능
			
			int[] arr = {1, 2, 3};
			System.out.println(arr[2]); //예외 발생 가능
			
			String str = null;
			System.out.println(str.length()); //예외 발생 가능
			
			System.out.println("try 블록 끝"); //출력 X
		} catch (ArithmeticException e) {
			e.printStackTrace(); //예외 발생 클래스, 위치, 원인 출력
			System.out.println("0으로 나눌 수 없음 - " + e.getMessage()); //예외 발생 원인 문자열로 리턴
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 인덱스가 잘못 지정됨 - " + e.getMessage());
//		} catch (Exception e) {
//			//각 예외에 따른 처리 방법 구분 불가
//			System.out.println("나머지 모든 예외 처리 - " + e.getMessage());
		} catch (NullPointerException e) {
			//Unreachable catch block 
			System.out.println("null값 참조 불가 - " + e.getMessage());
		} catch (Exception e) {
			//각 예외에 따른 처리 방법 구분 불가
			System.out.println("나머지 모든 예외 처리 - " + e.getMessage());
		}
		
		//try~catch 블록 밖의 코드는 예외 발생 여부와 관계없이 실행됨
		System.out.println("프로그램 종료");
		
	}

}
