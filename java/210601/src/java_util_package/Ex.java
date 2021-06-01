package java_util_package;

import java.util.Random;

public class Ex {

	public static void main(String[] args) {
		
		Random r = new Random();
		for(int i=1; i<=10; i++) {
//			System.out.println("int형 범위 난수 : " + r.nextInt());
//			System.out.println("double형 범위 난수 : " + r.nextDouble());
//			System.out.println("boolean형 범위 난수 : " + r.nextBoolean());
			
//			System.out.println("0 ~ 9 난수 : " + r.nextInt(10));
			System.out.println("1 ~ 10 난수 : " + (r.nextInt(10)+1));
		}
		
	}

}
