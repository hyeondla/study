
public class Test4 {

	public static void main(String[] args) {
		
		int score = 106;
	
		if(score >= 0 && score <= 100) {

			switch(score / 10) {
				case 10 :
				case 9 : System.out.println("A학점"); break;
				case 8 : System.out.println("B학점"); break;
				case 7 : System.out.println("C학점"); break;
				case 6 : System.out.println("D학점"); break;
				default : System.out.println("F학점");
			}
			
		} else {
			System.out.println("점수입력 오류");
		}
		
	}

}
