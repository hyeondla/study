import java.util.regex.Pattern;

public class Ex {
	
	public static void main(String[] args) {
		
		// 한글 이름 검증
		String name = "홍길동";
		String nameRegex = "^[가-힣]{2,5}$";
		
		if(Pattern.matches(nameRegex, name)) {
			System.out.println("올바른 한글 이름입니다");
		} else {
			System.out.println("잘못된 한글 이름입니다");
		}
		
		
		
		
		
	}
	
}
