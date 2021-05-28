package string_class;

import java.util.Arrays;

public class Ex {

	public static void main(String[] args) {

		String s1 = "Java Programming";
		String s2 = "                아이티윌        부산 교육센터                      ";
		String s3 = "자바/JSP/안드로이드";
		
		System.out.println(s1);
		System.out.println(s1.toString());
		
		System.out.println("--------------------------------------------");
		
		//length() : 문자열 길이
		System.out.println("s1.length() : " + s1.length());
		
		//equals() : 문자열 비교 
		System.out.println("s1.equals(\"JAVA PROGRAMMING\") : " + s1.equals("JAVA PROGRAMMING"));
		System.out.println("s1.equalsIgnoreCase(\"JAVA PROGRAMMING\") : " + s1.equalsIgnoreCase("JAVA PROGRAMMING")); //대소문자 구분 X
		
		//charAt() : 특정 인덱스에 위치한 문자 
		System.out.println("s1.charAt(5) : " + s1.charAt(5));
		
		//substring() : 특정 범위 문자열
		System.out.println("s1.substring(5) : " + s1.substring(5)); 
		System.out.println("s1.substring(5,12) : " + s1.substring(5,12)); //시작 ~ 끝-1 
		
		//concat() : 문자열 결합 (연결연산자보다 연산 속도 빠름)
		System.out.println("s1.concat(\"!\") : " + s1.concat("!"));
		
		//indexOf() : 특정 문자/문자열 인덱스 리턴, 없을시 -1 리턴, 첫번째인덱스부터 탐색
		System.out.println("s1.indexOf('a') : " + s1.indexOf('a'));
		System.out.println("s1.indexOf('x') : " + s1.indexOf('x'));
		System.out.println("s1.indexOf(\"a\") : " + s1.indexOf("a"));
		System.out.println("s1.indexOf(\"Program\") : " + s1.indexOf("Program"));
		
		//lastIndexOf() : 마지막인덱스부터 탐색
		System.out.println("s1.lastIndexOf('a') : " + s1.lastIndexOf('a'));
		
		//replace() : 특정 문자/문자열 치환
		System.out.println("s1.replace('a', '@') : " + s1.replace('a', '@'));
		System.out.println("s1.replace(\"Java\", \"Android\") : " + s1.replace("Java", "Android"));
		
		//toUpperCase(), toLowerCase() : 알파벳 대소문자 변환
		System.out.println("s1.toUpperCase() : " + s1.toUpperCase());
		System.out.println("s1.toLowerCase() : " + s1.toLowerCase());
		
		//trim() : 문자열 앞뒤 불필요한 공백 제거 (문자열 사이 공백 제거 X)
		System.out.println("교육기관은 " + s2.trim() + "입니다");
		
		//contains() : 문자열 포함 여부
		System.out.println("s2.contains(\"부산\") : " + s2.contains("부산"));
		System.out.println("s2.contains(\"강남\") : " + s2.contains("강남"));
		
		System.out.println("--------------------------------------------");
		
		//split() : 구분자 기준으로 문자열 분리, 분리된 문자열은 배열로 관리됨
		String[] subjectArr = s3.split("/");
		for(int i=0; i<subjectArr.length; i++) {
			System.out.println(subjectArr[i]);
		}
		//"."는 정규표현식에 사용되는 기호 
		String s4 = "안녕하세요.자바 프로그래밍입니다.";
//		String[] strArr = s4.split("."); //=> 모든 문자를 구분자로 지정, 제거됨
		String[] strArr = s4.split("\\."); //=> "\\." 사용
		for(int i=0; i<strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		System.out.println("============================================");
		
		//String.format()
		String name = "홍길동";
		int age = 20;
		double height = 180.7;
//		System.out.printf("이름 : %s, 나이 : %d, 키 : %.1f\n", name, age, height);
		
		String formatStr = String.format("이름 : %s, 나이 : %d, 키 : %.1f\n", name, age, height);
		System.out.println("생성된 회원 " + formatStr);
		
		System.out.println("============================================");
		
		//toCharArray() : 문자열을 char[]로 리턴
		String s5 = "admin123!";
		char[] chArr = s5.toCharArray();
		for(int i=0; i<chArr.length; i++) {
			System.out.print(chArr[i]);
		}
		System.out.println();
		
		//Arrays.toString() : 배열 내의 모든 데이터를 문자열로 결합하여 리턴
		System.out.println(Arrays.toString(chArr));
		
	}

}
