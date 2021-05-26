
public class Test {

	public static void main(String[] args) {
		
		String s1 = "Hello";
		String s2 = "Hello";
		
		if(s1 == s2) {
			System.out.println("주소값 같음");
		} else {
			System.out.println("주소값 다름");
		}
		
		if(s1.equals(s2)) {
			System.out.println("문자열 내용 같음");
		} else {
			System.out.println("문자열 내용 다름");
		}
		
		System.out.println("-------------------------");
		
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		
		if(s3 == s4) {
			System.out.println("주소값 같음");
		} else {
			System.out.println("주소값 다름");
		}
		
		if(s3.equals(s4)) {
			System.out.println("문자열 내용 같음");
		} else {
			System.out.println("문자열 내용 다름");
		}
		
	}

}
