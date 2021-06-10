package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connect_DELETE {

	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/java";
		String user = "root";
		String password = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 드라이버 로드
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			// DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공");
			
			// SQL 구문 작성 및 실행
			String name = "강감찬";
			int age = 30;
			
			// PreparedStatement 객체 사용 (만능문자 ? 사용)
			String sql = "DELETE FROM member WHERE name=? AND age>=?";
			pstmt = con.prepareStatement(sql); // SQL 전달
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			int deleteCount = pstmt.executeUpdate();
			
			// 결과 처리
			System.out.println("DELETE 작업 성공 - " + deleteCount + "개");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패 - " + driver);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		} finally { // 반환
			try {con.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
	}

}
