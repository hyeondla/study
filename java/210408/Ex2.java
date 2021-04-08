
public class Ex2 {

	public static void main(String[] args) {

		//중첩 if문
		
		int score = 90;
		String grade = "";
		
		if(score >= 0 && score <= 100) {
//			System.out.println("점수 입력 완료");
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
		} else {
			System.out.println(score + " : 점수 입력 오류");
		}
		
		System.out.println("---------------------------------------------");
		
		if(score >= 0 && score <= 100) {
			if(score >= 90) {
				grade = "A";
			} else if(score >= 80) {
				grade = "B";
			} else if(score >= 70) {
				grade = "C";
			} else if(score >= 60) {
				grade = "D";
			} else {
				grade = "F";
			}
			System.out.println(score + "점의 학점 : " + grade);
		} else {
		System.out.println(score + " : 점수 입력 오류");
		}
	
		
		
		
	}

}
