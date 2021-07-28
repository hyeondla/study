import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Ex {

	public static void main(String[] args) {

//		InputStream is = null;
//		
//		try {
//			
//			System.out.println("데이터를 입력하세요");
//			
//			is = System.in;
//			
//			int n = is.read(); // 1byte 정수로 리턴
//			System.out.println("입력된 데이터 : " + n);
//			System.out.println("입력 데이터 문자 변환 : " + (char)n);
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			// 자원 반환
//			try {
//				is.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		//=====================================================================
		
//		InputStream is = null;
//		
//		System.out.println("데이터를 입력하세요");
//		
//		try {
//			
//			is = System.in;
//			
//			int read = is.read(); // 입력 종료시 -1 리턴됨, \r = 13, \n = 10
//			while(read != -1) {
//				System.out.println("입력 데이터 : " + read + " -> 문자 변환 : " +(char)read);
//				read = is.read();
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				is.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		//=====================================================================
		
		System.out.println("데이터를 입력하세요");
		
		// try ~ resources : 자원 자동 반환
		try(InputStream is = System.in) { // 반환할 객체의 생성 코드, 세미콜론(;) 으로 다중 객체 
			
			int read = is.read(); 
			while(read != -1) {
				System.out.println("입력 데이터 : " + read + " -> 문자 변환 : " +(char)read);
				read = is.read();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
