
public class Ex {

	public static void main(String[] args) {

		NormalMethod nm = new NormalMethod();
		nm.addInt(10, 20);
		nm.addDouble(1.5, 3.14);
		
		System.out.println("-------------------------------------");
		
		// 메서드 오버로딩
		// - 호출 시점에 메서드 구분
		
		OverloadingMethod om = new OverloadingMethod();
		om.add(10, 20);
		om.add(1.5, 3.14);
		om.add(10, 20, 30);
		
	}

}

class OverloadingMethod {
	
	public void add(int num1, int num2) {
		System.out.println("add(int, int) 호출됨");
		System.out.println(num1 + num2);
	}
	
	public void add(double num1, double num2) {
		System.out.println("add(double, double) 호출됨");
		System.out.println(num1 + num2);
	}
	
	//변수명만 다를 경우 오버로딩 X
//	public void add(int a, int b) {
//		System.out.println(a + b);
//	}
	
	//리턴타입만 다를 경우 오버로딩 X
//	public int add(int num1, int num2) {
//		System.out.println(num1 + num2);
//		return num1 + num2;
//	}
	
	public void add(int num1, int num2, int num3) {
		System.out.println("add(int, int, int) 호출됨");
		System.out.println(num1 + num2 + num3);
	}
	
}

class NormalMethod {

	public void addInt(int num1, int num2) {
		System.out.println(num1 + num2);
	}

	public void addDouble(double num1, double num2) {
		System.out.println(num1 + num2);
	}

}