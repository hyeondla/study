import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
	
	public static void main(String[] args) {
		
		String[] passwords = {
				"Abcde123!",
				"abcde123@",
				"abcde123",
				"12345678",
				"abcde한글!",
				"abcde123*",
				"a123!"
		};
		
		String lengthRegex = "^[A-Za-z0-9!@#$%]{8,16}$";
		String engUpperRegex = "[A-Z]";
		String engLowerRegex = "[a-z]";
		String numberRegex = "[0-9]"; // 0-9 == \\d
		String specRegex = "[!@#$%]";
		
		for(String pass : passwords) {
			
			if(Pattern.matches(lengthRegex, pass)) {
				
				int safetyCount = 0;
				
//				Matcher matcher = Pattern.compile(engUpperRegex).matcher(pass);
//				if(matcher.find()) {
//					safetyCount++;
//				}
				if(Pattern.compile(engUpperRegex).matcher(pass).find()) {
					safetyCount++;
				}
				if(Pattern.compile(engLowerRegex).matcher(pass).find()) {
					safetyCount++;
				}
				if(Pattern.compile(numberRegex).matcher(pass).find()) {
					safetyCount++;
				}
				if(Pattern.compile(specRegex).matcher(pass).find()) {
					safetyCount++;
				}
				
				switch (safetyCount) {
				case 1:
					System.out.println(pass + " - 사용불가");
					break;
				case 2:
					System.out.println(pass + " - 위험");
					break;
				case 3:
					System.out.println(pass + " - 보통");
					break;
				case 4:
					System.out.println(pass + " - 안전");
					break;

				}
				
			} else {
				System.out.println(pass + " - 부적합");
			}
		}
		
	}
	
}
