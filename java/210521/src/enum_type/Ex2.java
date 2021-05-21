package enum_type;

public class Ex2 {

	public static void main(String[] args) {

		Week today = Week.FRIDAY;

		if (today == Week.WEDNESDAY) {
			System.out.println("금요일");
		} else {
			System.out.println("금요일 아님");
		}

		// case문 사용시 enum.상수가 아닌 상수 자체를 비교
		switch (today) {
		case MONDAY:
			System.out.println("월요일");
			break;
		case TUESDAY:
			System.out.println("화요일");
			break;
		case WEDNESDAY:
			System.out.println("수요일");
			break;
		case THURSDAY:
			System.out.println("목요일");
			break;
		case FRIDAY:
			System.out.println("금요일");
			break;
		case SATURDAY:
			System.out.println("토요일");
			break;
		case SUNDAY:
			System.out.println("일요일");
			break;
		}

		switch (today) {
		case MONDAY:
			break;
		case TUESDAY:
			break;
		case WEDNESDAY:
			break;
		case THURSDAY:
			System.out.println("평일");
			break;
		case FRIDAY:
			System.out.println("내일은 주말");
			break;
		case SATURDAY:
			break;
		case SUNDAY:
			System.out.println("주말");
			break;
		}
		
		System.out.println("===============================");
		
		//ordinal() : 상수의 순서번호를 정수로 리턴
		System.out.println("오늘의 ordinal 값 : " + today.ordinal()); 
		
		if(today.ordinal() > 4) {
			System.out.println("주말");
		} else {
			System.out.println("평일");
		}
		
		//name() : 상수명을 문자열로 리턴
		String strToday = today.name();
		System.out.println(strToday);
		
	}

}
