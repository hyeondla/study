package enum_type;

public class Ex {

	public static void main(String[] args) {

		// 열거형 Enum

//		Week today; //Week타입 상수만 저장 가능
//		today = Week.FRIDAY;
		Week today = Week.FRIDAY;
		System.out.println(today);

		System.out.print("Enum 클래스의 서브클래스 : ");
		if (today instanceof Enum) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}

		System.out.print("Object 클래스의 서브클래스 : ");
		if (today instanceof Object) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}

		System.out.println("================================");

		// 일반 상수 파라미터
		// => 동일한 데이터 타입인 경우 잘못된 데이터도 전달 가능
		MyCalendar mc = new MyCalendar();
		mc.setMonth(20); // int 타입 데이터 전달 가능 (잘못된 데이터)
		mc.setMonth(WeekClass.MONDAY); // 요일 전달 가능 (잘못된 데이터)
		mc.setMonth(MonthClass.JANUARY); // 정상 데이터

		// enum 상수 파라미터
		// => enum 타입 상수 외에 전달 불가
		MyEnumCalendar mec = new MyEnumCalendar();
//		mec.setMonth(1); //오류! Month 타입 객체 외 다른 값 전달 불가
//		mec.setMonth(Week.MONDAY); //오류!
		mec.setMonth(Month.MAY); // Month 타입 상수만 사용 가능
	}

}

enum Week {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

enum Month {
	JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY
}

class MyEnumCalendar {
	public void setMonth(Month month) {
		System.out.println(month + "월");
	}
}

//=================================================================

//요일 정보 
class WeekClass {

	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;
	public static final int SUNDAY = 7;

}

//월 정보
class MonthClass {
	public static final int JANUARY = 1;
}

class MyCalendar {

	public void setMonth(int month) {
		System.out.println(month + "월");
	}
}
