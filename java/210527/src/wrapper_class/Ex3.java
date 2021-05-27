package wrapper_class;

public class Ex3 {

	public static void main(String[] args) {
		
		//문자열 -> 기본데이터타입
		
		String strNum = "100.0";
		
//		int iNum = Integer.parseInt(strNum);
		//String 실수 -> int 변환 불가
		//실행 시점에 오류 NumberFormatException
		
		Double dNum = Double.parseDouble(strNum);
		System.out.println(dNum);
		
		Double dNum2 = new Double(strNum); //생성자에 문자열 전달
		System.out.println(dNum2);
		
		strNum = "1234";
		
		int iNum = Integer.parseInt(strNum);
		System.out.println(iNum);
		
	}

}
