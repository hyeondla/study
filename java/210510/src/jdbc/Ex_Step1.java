package jdbc;

public class Ex_Step1 {

	public static void main(String[] args) {
 
		//1. JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		}
		
	
	}

}
