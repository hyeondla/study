
public class Ex {

	public static void main(String[] args) {
		
//		StringBuffer sb = new StringBuffer(); // 널 스트링("") 객체 생성
		StringBuffer sb = new StringBuffer("Hello"); // 문자열 객체 생성
		
		System.out.println(sb); // toString() 생략됨
		
		String str = sb.toString();
		System.out.println(str);
		
		sb.append(", Java");
		System.out.println(sb);
		
	}

}
