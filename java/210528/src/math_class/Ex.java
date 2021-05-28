package math_class;

public class Ex {

	public static void main(String[] args) {
		
		System.out.println("PI : " + Math.PI);
		
		System.out.println("--------------------------------------------");
		
		int num = -10;
		System.out.println("절대값 : " + Math.abs(num));
		System.out.println(Math.max(num, 20));
		System.out.println(Math.min(num, 20));
		System.out.println("4 제곱근 : " + Math.sqrt(4));
		
		//------------------------------------------------------------------
		
		double dNum = 3.141592;
		System.out.println(Math.ceil(dNum)); //소수점 첫째자리에서 올림 (리턴타입 double)
		System.out.println(Math.floor(dNum)); //소수점 첫째자리에서 버림 (리턴타입 double)
		System.out.println(Math.round(dNum)); //소수점 첫째자리에서 반올림 (리턴타입 long)
		System.out.println(Math.round(dNum*1000)/1000.0);
		System.out.println(Math.round(dNum*Math.pow(10, 3))/Math.pow(10.0, 3));
		
		//특정 소수점자리까지만 남기고 제거
		//=> 특정 소수점자리의 숫자까지 정수자리에 위치
		//=> 정수화
		//=> 처음 곱한 값으로 다시 나눔 (소수점 -> double타입 실수로 나누어야 함)
		System.out.println((int)(dNum*10000)/10000.0);
		
	}

}
