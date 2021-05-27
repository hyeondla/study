package wrapper_class;

public class Test4 {

	public static void main(String[] args) {

		char[] chArr = { 'A', 'b', '5', ' ', '#' };

		for (int i = 0; i < chArr.length; i++) {

			if (Character.isUpperCase(chArr[i])) {
				System.out.println(chArr[i] + " : 대문자");
			} else if (Character.isLowerCase(chArr[i])) {
				System.out.println(chArr[i] + " : 소문자");
			} else if (Character.isDigit(chArr[i])) {
				System.out.println(chArr[i] + " : 숫자");
			} else {
				System.out.println(chArr[i] + " : 기타문자");
			}

		}

	}

}
