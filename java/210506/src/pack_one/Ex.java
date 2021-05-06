package pack_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
//단축키 : ctrl + shift + o

public class Ex {

	public static void main(String[] args) {

		// java.lang 패키지의 String 클래스 선언
		java.lang.String str;

		// java.lang 패키지는 생략 가능
		String str2;

		// java.util 패키지는 생략 불가
//		Random r;

		// => 클래스명 앞에 패키지명 명시
		java.util.Random r;

		// => 클래스가 포함된 패키지를 import문으로 지정
		// => 클래스명만으로 사용 가능
		Random r2;

		ArrayList list;

		IOException e1;
		BufferedReader reader;

	}

}
