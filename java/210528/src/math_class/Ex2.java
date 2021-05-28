package math_class;

public class Ex2 {

	public static void main(String[] args) {

		// Math.random()
		// 0.0 <= x < 1.0 난수

		for (int i = 1; i <= 10; i++) {
//			System.out.println(Math.random());
//			System.out.println((int) (Math.random() * 10)); // 0 <= x < 10
//			System.out.println((int) (Math.random() * 10) + 1); // 1 <= x < 11
			System.out.println((int) (Math.random() * 20) + 1);
		}

	}

}
