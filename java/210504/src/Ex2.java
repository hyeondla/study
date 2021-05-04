
public class Ex2 {

	public static void main(String[] args) {

		Money m = new Money();
		PassByTest pbt = new PassByTest();

		// 1. 메서드 파라미터로 기본 데이터타입 변수 값 전달 => 실제값 복사해서 전달
		System.out.println("change() 메서드 호출 전 money = " + m.money);
		pbt.changePrimitiveType(m.money);
		System.out.println("change() 메서드 호출 후 money = " + m.money);
		// => 원본 데이터에 영향 X

		System.out.println("==============================================");

		// 2. 메서드 파라미터로 참조 데이터타입 변수 값 전달 => 주소값 복사해서 전달
		System.out.println("change() 메서드 호출 전 money = " + m.money);
		pbt.changeReferenceType(m);
		System.out.println("change() 메서드 호출 후 money = " + m.money);
		// => 원본 데이터도 동일한 주소값을 참조하므로 변경시 영향 O
	}

}

class PassByTest {

	public void changePrimitiveType(int m) {
		m -= 5000;
		System.out.println("changePrimitiveType() 메서드 money = " + m);
	}

	public void changeReferenceType(Money m) {
		m.money -= 5000;
		System.out.println("changeReferenceType() 메서드 money = " + m.money);
	}

}

class Money {
	int money = 10000;
}