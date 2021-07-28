import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex4 {

	public static void main(String[] args) {
		
		// BufferdReader 객체
		// readLine() -> String 단위 처리
		// 스트림 체이닝 형식으로 객체 생성하여 사용
		// InputStream -> InputStreamReader -> BufferedReader
		
		System.out.println("데이터를 입력하세요");
		
//		InputStream is = System.in; // 입력스트림 객체 생성
//		InputStreamReader reader = new InputStreamReader(is); // InputStream -> InputStreamReader 연결
//		BufferedReader buffer = new BufferedReader(reader); //InputStreamReader -> BufferedReader 연결
		
		
		// 데코레이션 패턴
//		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
//		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
//			String str = buffer.readLine();
//			System.out.println(str);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
//		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
//		
//			String str = buffer.readLine();
//			// Ctrl + Z -> 리턴값 null
//			while(str != null) {
//				System.out.println(str);
//				str = buffer.readLine();
//			}
//			System.out.println("입력 종료");
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
			
			String text = "";
			String str = buffer.readLine();
			
			// Ctrl + Z -> 리턴값 null
			while(!str.equals(":wq!")) {
				text += str + "\n";
				str = buffer.readLine();
			}
			
			System.out.println("------------------------------");
			System.out.println(text);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
