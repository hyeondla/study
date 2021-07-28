import java.io.IOException;
import java.io.InputStream;

public class Ex2 {

	public static void main(String[] args) {
		
		System.out.println("데이터를 입력하세요");
		
		try (InputStream is = System.in) {
			
			// 10byte 단위 입력데이터 저장 공간 생성
			// 지정된 배열크기만큼만 읽어올 수 있음 
			byte[] b = new byte[10]; 
			
			int read = is.read(b); // 입력데이터가 아닌 입력데이터의 크기 (byte) 리턴됨
			System.out.println("입력된 데이터 byte 수 : " + read);
			
//			for(byte letter : b) {
//				System.out.println("입력 데이터 : " + letter + " -> 문자 변환 : " + (char)letter);
//			}
			String str = new String(b);
			System.out.println("문자열 변환 결과 : " + str);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
