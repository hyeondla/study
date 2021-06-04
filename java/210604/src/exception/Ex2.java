package exception;

public class Ex2 {

	public static void main(String[] args) {
		
		try {
			printScore(150);
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println("--------------------------------------------");
		
		try {
			userExceptionMethod(150);
		} catch (InvalidScoreException e) {
			e.printStackTrace();
		}
		
	}

	public static void printScore(int score) throws Exception {
		
		if(score < 0 || score > 100) {
//			System.out.println("점수입력 오류");
			//throw -> 예외 클래스 객체 생성
//			Exception e = new Exception("점수 입력 오류 - " + score);
//			throw e; //예외 발생
			throw new Exception("점수 입력 오류 - " +  score);
		}
		
	}
	
	public static void userExceptionMethod(int score) throws InvalidScoreException{
		if(score < 0 || score > 100) {
			throw new InvalidScoreException("점수 입력 오류 - " + score); 
		}
	}

}

//사용자 정의 예외 클래스
class InvalidScoreException extends Exception {

	public InvalidScoreException(String message) {
		super(message);
	}
	
}