package java_util_package;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Ex5 {

	public static void main(String[] args) {

		Date today = new Date();
		System.out.println(today);
	
		String pattern = "yyyy년 MM월 dd일 EEEE";
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		System.out.println(sdf.format(today));
	
		String formatToday = sdf.format(today);
		System.out.println(formatToday);
		
		pattern = "yyyy/MM/dd(E) a HH:mm:ss";
		SimpleDateFormat sdf2 = new SimpleDateFormat(pattern);
		System.out.println(sdf2.format(today));
		
		System.out.println("============================================");
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);

		System.out.println(now.format(dtf));
		
	}

}
