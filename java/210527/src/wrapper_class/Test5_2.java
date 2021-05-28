package wrapper_class;

public class Test5_2 {

	public static void main(String[] args) {
		
		String pass = "admin123";
		char[] chArr = pass.toCharArray();

		boolean[] check = new boolean[4];
		int safetyScore = 0;

		for (int i = 0; i < chArr.length; i++) {
			if (Character.isUpperCase(chArr[i])) {
				check[0] = true;
			} else if (Character.isLowerCase(chArr[i])) {
				check[1] = true;
			} else if (Character.isDigit(chArr[i])) {
				check[2] = true;
			} else if (chArr[i] == '!') {
				check[3] = true;
			}
		}

		for (int i = 0; i < check.length; i++) {
			if (check[i]) {
				safetyScore++;
			}
		}

		switch (safetyScore) {
			case 4: System.out.println("패스워드 안전도 : 안전"); break;
			case 3: System.out.println("패스워드 안전도 : 보통"); break;
			case 2: System.out.println("패스워드 안전도 : 위험"); break;
			case 1: 
			default: System.out.println("패스워드 안전도 : 사용 불가!");
		}

	}

}
