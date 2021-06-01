package java_util_package;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Ex4 {

	public static void main(String[] args) {

		LocalDate date = LocalDate.now();
		System.out.println(date);
			
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		
		System.out.println("--------------------------------------------");
		
		LocalDate date2 = LocalDate.of(2000, 1, 1);
		System.out.println(date2);
		
		LocalTime time2 = LocalTime.of(17, 40, 00);
		System.out.println(time2);
		
		LocalDateTime dateTime2 = LocalDateTime.of(date2, time2);
		System.out.println(dateTime2);

		System.out.println("--------------------------------------------");
		
		int year = date.getYear();
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();
		
		System.out.println(year + "/" + month +"/" + day);
		
		Month enumMonth = date.getMonth();
		System.out.println(enumMonth);
		String monthName = enumMonth.toString();
		
		System.out.println(enumMonth.getDisplayName(TextStyle.SHORT, Locale.KOREAN));
		
		
		int hour = time.getHour();
		int min = time.getMinute();
		int sec = time.getSecond();
		
		System.out.println(hour + ":" + min + ":" + sec);
		
		System.out.println("============================================");
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		System.out.println(today.plusMonths(8));
		System.out.println(today.plusDays(300).plusDays(15));
		
		System.out.println("============================================");
		
		LocalDate date3 = LocalDate.of(2000, 1, 1);
		LocalDate date4 = LocalDate.now();
		
		System.out.println(date3.compareTo(date4));
		
		System.out.println(date3.isAfter(date4));
		System.out.println(date3.isBefore(date4));
		
		System.out.println(date3.isEqual(date4));
		
		long result = date3.until(date4, ChronoUnit.YEARS);
//		System.out.println(result);
		if(result > 0) {
			System.out.println(result + "년 남았습니다");
		} else if(result < 0) {
			System.out.println(-result + "년 지났습니다");
		} else {
			System.out.println("올해입니다");
		}
		
		
	}

}
