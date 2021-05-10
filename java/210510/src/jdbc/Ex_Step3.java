package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex_Step3 {

	public static void main(String[] args) {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/java";
		String user = "root";
		String password = "1234";
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공");
			
			//3. SQL 구문 전달 및 실행
			String sql = "INSERT INTO test VALUES (3)"; //실행할 SQL 구문 작성
//			String sql = "DELETE FROM test";
			PreparedStatement pstmt = con.prepareStatement(sql);
			

			int insertCount = pstmt.executeUpdate(); //INSERT, UPDATE, DELETE 구문 실행 (데이터 조작어)
			System.out.println("추가된 레코드 수 : " + insertCount);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패 / 구문 오류 발생");
		}
		
		
	}

}
