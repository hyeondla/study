package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex_Step4 {

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

			String sql = "SELECT * FROM test"; 
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); //SELECT 구문 실행
			
//			if(rs.next()) {
//				System.out.println("다음 레코드가 존재함!");
//			} else {
//				System.out.println("다음 레코드가 존재하지 않음!");
//			}
			
			while(rs.next()) {
				
				System.out.println("다음 레코드가 존재함");
				//ResultSet 객체의 getXXX() 메서드 호출 -> 데이터 가져옴
				//int 타입 -> getInt();
				//varchar 타입 -> getString();
//				int idx = rs.getInt(1); //Index 컬럼인덱스 => 1부터 시작
				int idx = rs.getInt("idx"); //Label 컬럼명
				System.out.println(idx);
				
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패 / 구문 오류 발생");
		}

	}

}












