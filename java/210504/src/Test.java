
public class Test {

	public static void main(String[] args) {

		VariableArgumentsTest va = new VariableArgumentsTest();

		int[] num = { 1, 2, 3, 4, 5, 6 };

		va.print();
		va.print(10, 20, 30);
		va.print(num);

	}

}

class VariableArgumentsTest {

	public void print(int... nums) {

		if (nums.length == 0) {
			System.out.println("전달받은 정수 없음");
		} else {
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
		}
	}

}