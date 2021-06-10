package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connect_SELECT {

	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/java";
		String user = "root";
		String password = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 드라이버 로드
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			// DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공");
			
			// PreparedStatement 객체 사용 (만능문자 ? 사용)
			String sql = "SELECT * FROM member";
			pstmt = con.prepareStatement(sql); // SQL 전달
			rs = pstmt.executeQuery();
			
			// 결과 처리 => 테이블 형태
			while(rs.next()) {
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String jumin = rs.getString("jumin");
				
				System.out.printf("idx:%d | name:%s | age:%d | gender:%s | jumin:%s\n", idx, name, age, gender, jumin);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패 - " + driver);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		} finally { // 반환
			try {rs.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {con.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
	}

}
