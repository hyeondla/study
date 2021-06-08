package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connect_INSERT {

	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/java";
		String user = "root";
		String password = "1234";
		
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			// 드라이버 로드
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			// DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공");
			
			// SQL 구문 작성 및 실행
			String name = "이순신";
			int age = 43;
			String gender = "남";
			String jumin = "701010-1233444";
			
			// statement 객체 사용 (문자열 결합 -> 보안상 사용 X)
			/*
			String sql = "INSERT INTO member VALUES (null,'" + name + "'," + age + ",'" + gender + "','" + jumin + "')";
			stmt = con.createStatement(); // SQL 전달 X
			int insertCount = stmt.executeUpdate(sql); // 실행 시점에 전달됨
			*/
			
			//----------------------------------------------------------------------
			
			// PreparedStatement 객체 사용 (만능문자 ? 사용)
			String sql = "INSERT INTO member VALUES (null,?,?,?,?)";
			pstmt = con.prepareStatement(sql); // SQL 전달
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, gender);
			pstmt.setString(4, jumin);
			int insertCount = pstmt.executeUpdate();
			
			// 결과 처리
			System.out.println("INSERT 작업 성공 - " + insertCount + "개");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패 - " + driver);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		} finally { // 반환
			try {con.close();} catch (SQLException e) {e.printStackTrace();}
			try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
	}

}
