import java.util.regex.Pattern;

public class Ex {
	
	public static void main(String[] args) {
		
		// 한글 이름 검증
//		String name = "홍길동";
//		String nameRegex = "^[가-힣]{2,5}$";
//		
//		if(Pattern.matches(nameRegex, name)) {
//			System.out.println("올바른 한글 이름입니다");
//		} else {
//			System.out.println("잘못된 한글 이름입니다");
//		}
		
		
		// 전화번호 검증
		String[] strPhoneArr = {
			"010-1234-5678",
			"010-1234-567a",
			"01012345678",
			"010 1234 5678",
			"010-123-5678",
			"010_1234_5678"
		};
		
		String phoneRegex = "^(010|011)[-\\s]?\\d{3,4}[-\\s]?\\d{4}$";
		
		for(String str : strPhoneArr) {
			if(Pattern.matches(phoneRegex, str)) {
				System.out.println(str + " 올바른 번호입니다");
			} else {
				System.out.println(str + " 잘못된 번호입니다");
			}
		}
		
		
		
	}
	
}
