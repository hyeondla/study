import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2 {

	public static void main(String[] args) {
		
		String src = "Java and Javascript has no relation";
		String regex = "Java";
		
//		Pattern pattern = Pattern.compile(regex);
//		Matcher matcher = pattern.matcher(src);
		Matcher matcher = Pattern.compile(regex).matcher(src);
		
		System.out.println("원본 문자열이 정규표현식과 완전 일치 - " + matcher.matches());
		
		System.out.println("원본 문자열이 정규표현식으로 시작 - " + matcher.lookingAt());
		
		System.out.println("원본 문자열이 정규표현식을 포함 - " + matcher.find());
		
	}

}
