package wrapper_class;

import java.util.Arrays;

public class Test5 {

	public static void main(String[] args) {

		String str = "Hello";
		char[] chArr = str.toCharArray();

		char[] enArr = encrypt(chArr);
		System.out.println(Arrays.toString(enArr));

	}

	public static char[] encrypt(char[] chArr) {

		for (int i = 0; i < chArr.length; i++) {
			chArr[i] += 3;
		}
		return chArr;

	}

}
