package java_util_package;

import java.util.Calendar;
import java.util.Date;

public class Ex3 {

	public static void main(String[] args) {

//		Calendar cal = new Calender(); //추상 클래스 -> 인스턴스 생성 불가
		Calendar cal = Calendar.getInstance();
//		System.out.println(cal);
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; // 0 ~ 11
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year + "년 " + month + "월 " + day + "일 ");
		
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		
		System.out.println(hour + "시 " + min + "분 " + sec + "초");
		
		// Calender -> Date
		Date date = cal.getTime();
		System.out.println(date);
		
		// Date -> Calender
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date);
		
		System.out.println("============================================");
		
		cal2.set(1999, 12 - 1, 31);
		
		cal2.set(Calendar.YEAR, 2010);
		cal2.set(Calendar.MONTH, 5 - 1); 
		
		Date date2 = cal2.getTime();
		System.out.println(date2);
		
	}

}
