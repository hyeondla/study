package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	//메서드 정의
	
	//DB연결
	private Connection getConnection() throws Exception {//예외처리 → 메서드 호출하는 곳에서 처리
//		//드라이버 로더
//		Class.forName("com.mysql.jdbc.Driver");
//		//DB 서버 접속
//		String dbUrl="jdbc:mysql://localhost:3306/jspdb3";
//		String dbUser="root";
//		String dbPass="1234";
//		Connection con=DriverManager.getConnection(dbUrl,dbUser,dbPass);
//		
//		return con;
		
		/*
			Connection Pool => DBCP API 사용
			1. META-INF 폴더 context.xml 생성
			2. DAO 파일에서 자원 호출, 사용
		*/
		
		//javax.naming
		Context init = new InitialContext();
		//javax.sql
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/MysqlDB"); //다운캐스팅
		Connection con = ds.getConnection();
		
		return con;
	}
	
	//insert
	public void insertMember(MemberBean mb) {
		//선언부
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try { //예외처리
			//연결 메서드 호출
			con = getConnection();
			//sql문
			String sql="insert into member(id,pass,name,date) values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPass());
			pstmt.setString(3, mb.getName());
			pstmt.setTimestamp(4, mb.getDate());
			//실행
			pstmt.executeUpdate();
		} catch (Exception e) {
			//예외 추적 메시지 출력
			e.printStackTrace();
		} finally {
			//예외 상관없이 처리
			//기억장소 해제
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
			if(con != null) {
				try { con.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
		}
		
		return;
	}
	
	//info
	public MemberBean getMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBean mb = new MemberBean();
		try {
			
			con = getConnection();
			
			String sql = "select * from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mb.setId(rs.getString("id"));
				mb.setPass(rs.getString("pass"));
				mb.setName(rs.getString("name"));
				mb.setDate(rs.getTimestamp("date"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
			if(con != null) {
				try { con.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
		}
		
		return mb;
	}
	
	//login
	public MemberBean userCheck(String id, String pass) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBean mb = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from member where id=? and pass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
						
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mb = new MemberBean();
				mb.setId(rs.getString("id"));
				mb.setPass(rs.getString("pass"));
				mb.setName(rs.getString("name"));
				mb.setDate(rs.getTimestamp("date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
			if(con != null) {
				try { con.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
		}
		
		return mb;
	}
	
	//update
	public void updateMember(MemberBean mb) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			
			String sql = "update member set name=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,mb.getName());
			pstmt.setString(2,mb.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
			if(con != null) {
				try { con.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
		}
	}
	
	//delete
	public void deleteMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			
			String sql = "delete from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
			if(con != null) {
				try { con.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
		}
	}
	
	//list
	public List<MemberBean> getMemberList() {
		
//		List memberList = new ArrayList();
		List<MemberBean> memberList = new ArrayList<MemberBean>();
		//=> 제네릭 타입 : 특정 형을 지정해서 저장
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberBean mb = new MemberBean();
				mb.setId(rs.getString("id"));
				mb.setPass(rs.getString("pass"));
				mb.setName(rs.getString("name"));
				mb.setDate(rs.getTimestamp("date"));
				
				memberList.add(mb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
			if(con != null) {
				try { con.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
		}
		return memberList;
	}
}
