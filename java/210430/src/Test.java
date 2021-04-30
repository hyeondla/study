
public class Test {

	public static void main(String[] args) {

		PrintOverloding po = new PrintOverloding();
		po.print(4.325);
		po.print(2);
		po.print("Hello");
		po.print();

		System.out.println("============================");

		Calculater c = new Calculater();
//		cal.add(1, 2);
//		cal.add(1, 2, 3);
//		cal.add(1, 2, 3, 4);

		c.cal('+', 10, 20);
		c.cal('+', 10, 20, 30);
		c.cal('+', 10, 20, 30, 40);
		
		c.cal('-', 100, 10);
		c.cal('-', 100, 10, 20);
		c.cal('-', 100, 10, 20, 30);
		
	}

}

class Calculater {

//	public void add(int num1, int num2) {
//		System.out.println(num1 + num2);
//	}
//	
//	public void add(int num1, int num2, int num3) {
//		System.out.println(num1 + num2 + num3);
//	}
//	
//	public void add(int num1, int num2, int num3, int num4) {
//		System.out.println(num1 + num2 + num3 + num4);
//	}

	public void cal(char op, int num1, int num2) {
		if (op == '+') {
			System.out.println(num1 + num2);
		} else if (op == '-') {
			System.out.println(num1 - num2);
		}
	}

	public void cal(char op, int num1, int num2, int num3) {
		if (op == '+') {
			System.out.println(num1 + num2 + num3);
		} else if (op == '-') {
			System.out.println(num1 - num2 - num3);
		}
	}

	public void cal(char op, int num1, int num2, int num3, int num4) {
		if (op == '+') {
			System.out.println(num1 + num2 + num3 + num4);
		} else if (op == '-') {
			System.out.println(num1 - num2 - num3 - num4);
		}

	}
	
}

class PrintOverloding {

	public void print(int num) {
		System.out.println(num);
	}

	public void print(double num) {
		System.out.println(num);
	}

	public void print(String str) {
		System.out.println(str);
	}

	public void print() {
		System.out.println("줄바꿈");
	}

}