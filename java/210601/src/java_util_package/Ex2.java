package java_util_package;

import java.util.Date;

public class Ex2 {

	public static void main(String[] args) {

		Date d1 = new Date();
		System.out.println(d1);
		
//		Date d2 = new Date(0); // 1970년 1월 1일 09시 기준
		Date d2 = new Date(2000000000000L); // 밀리초(ms) 단위
		System.out.println(d2);
		
		long differentDate = d2.getTime() - d1.getTime();
//		System.out.println(differentDate);
//		System.out.println(differentDate/1000 + "초");
//		System.out.println(differentDate/1000/60 + "분");
//		System.out.println(differentDate/1000/60/60 + "시");
//		System.out.println(differentDate/1000/60/60/24 + "일");			
		
		if(differentDate > 0) {
			System.out.println(differentDate/1000/60/60/24 + "일 남았습니다");			
		} else if(differentDate < 0) {
			System.out.println(differentDate/1000/60/60/24 + "일 지났습니다");						
		} else {
			System.out.println("오늘입니다");
		}
		
	}

}
