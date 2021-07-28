import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex3 {

	public static void main(String[] args) {
		
		// InputStreamReader 객체 사용 -> char(2byte) 처리
		// 한글, 한자 등 유니코드 처리 가능
		// int -> char 변환 필요
		
		System.out.println("데이터를 입력하세요");
		
		// InputStream 객체 
//		InputStream is = System.in; 
		
		// InputStreamReader 객체의 생성자 파라미터로 전달
//		InputStreamReader reader = new InputStreamReader(is);
		
//		InputStreamReader reader = new InputStreamReader(System.in);
		
		try (InputStreamReader reader = new InputStreamReader(System.in)) {
			
			int data = reader.read();
			
//			System.out.println(data);
			System.out.println("입력 데이터 : " + data + " -> 문자 변환 : " + (char)data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
