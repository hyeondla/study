import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MemberDAO {
	
	private Connection getConnection() {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/java";
		String user = "root";
		String password = "1234";
		
		try {
			//1. 드라이버 로드
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			//2. DB 연결
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공");
			
			return con;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패 - " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 연결 실패 - " + e.getMessage());
		}
		return null;
	}
	
	// 자원 반환
	private void close(Connection con) {
		if(con != null) { try { con.close(); } catch(Exception e) {} }
	}
	private void close(PreparedStatement pstmt) {
		if(pstmt != null) { try { pstmt.close(); } catch(Exception e) {} }
	}
	private void close(ResultSet rs) {
		if(rs != null) { try { rs.close(); } catch(Exception e) {} }
	}
	
	// 로그인 작업
	public boolean login(String dbUsername, String dbPassword) throws LoginFailedException {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT password FROM user WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dbUsername);
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) { 
				// 아이디 존재
				if(rs.getString("password").equals(dbPassword)) {
					// 비밀번호 일치
					return true; // 로그인 성공
				} else {
					// 비밀번호 불일치
					throw new LoginFailedException("패스워드 틀림");
				}
			} else {
				// 아이디 없음
				throw new LoginFailedException("아이디 없음");
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		return false;
	}

	// 회원 추가
	public int insert(MemberDTO dto) {
		int insertCount = 0;
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO customer VALUES(null,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getJumin());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - " + e.getMessage());
		} finally {
			close(pstmt);
			close(con);
		}
		return insertCount;
	}
	
	// 회원 삭제
	public int delete(int idx) {
		int deleteCount = 0;
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM customer WHERE idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - " + e.getMessage());
		} finally {
			close(pstmt);
			close(con);
		}
		return deleteCount;
	}
	
	// 회원 조회
	public Vector<Vector> select() { 
		Vector<Vector> memberList = null;
 		
 		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM customer";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			memberList = new Vector();
			while(rs.next()) {
				Vector member = new Vector();
				
				member.add(rs.getInt("idx"));
				member.add(rs.getString("name"));
				member.add(rs.getInt("age"));
				member.add(rs.getString("email"));
				member.add(rs.getString("jumin"));
//				System.out.println(member);
				
				memberList.add(member);
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}
 		return memberList;
	}
	
	
}
