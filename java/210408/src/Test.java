
public class Test {

	public static void main(String[] args) {

		char ch = '*';
		
		if(ch >= 'A' && ch <= 'Z') {
			System.out.println(ch + " : 대문자");
		} else if(ch >= 'a' && ch <= 'z') {
			System.out.println(ch + " : 소문자");
		} else if(ch >= '0' && ch <= '9') {
			System.out.println(ch + " : 숫자");
		} else {
			System.out.println(ch + " : 기타 문자");
		}
		
		System.out.println("-----------------------------");
		
		ch = 'j';
		
		if(ch >= 'A' && ch <= 'Z') {
			ch += 32;
			System.out.println("대문자 --> 소문자로 변환 : " + ch);
		} else if(ch >= 'a' && ch <= 'z') {
			ch -= 32;
			System.out.println("소문자 --> 대문자로 변환 : " + ch);
		} else {
			System.out.println(ch + " --> 변환 불가");
		}
		
		System.out.println("==================================");
		
		int score = 90;
		String grade = "";
		
		if(score >= 90 && score <= 100) {
			grade = "A";
		} else if(score >= 80 && score < 90) {
			grade = "B";
		} else if(score >= 70 && score < 80) {
			grade = "C";
		} else if(score >= 60 && score < 70) {
			grade = "D";
		} else if(score >= 0 && score < 60){
			grade = "F";
		}
		
		System.out.println(score + "점의 학점 : " + grade);
		
	}

}
