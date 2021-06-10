package jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MemberDAO {

	private Connection getConnection() {
		
		Connection con = null;
		
		String driver = "";
		String url = "";
		String user = "";
		String password = "";
		
		try {
			
			Properties props = new Properties();
			props.load(new FileReader("D:\\user_info.properties"));
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			
			System.out.println("드라이버 : " + driver);
			System.out.println("url : " + url);
			System.out.println("아이디 : " + user);
			System.out.println("패스워드 : " + password);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//----------------------------------------------------
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	//자원 반환
	private void close(Connection con) {
		if(con != null) { try { con.close(); } catch(Exception e) {} }
	}
	private void close(PreparedStatement pstmt) {
		if(pstmt != null) { try { pstmt.close(); } catch(Exception e) {} }
	}
	private void close(ResultSet rs) {
		if(rs != null) { try { rs.close(); } catch(Exception e) {} }
	}
	
	
	public int insert(MemberDTO dto) {
		
		int insertCount = 0;

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO member VALUES (null,?,?,?,?)";
			pstmt = con.prepareStatement(sql); // SQL 전달
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getJumin());
			insertCount = pstmt.executeUpdate();
			
			System.out.println("INSERT 작업 성공 - " + insertCount + "개");
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - " + e.getMessage());
		} finally {
			close(pstmt);
			close(con);
		}
		
		return insertCount;
		
	}
	
	public void update() {
		
	}
	
	public void delete() {
		
	}
	
	public void select() {
		
	}
	
}
