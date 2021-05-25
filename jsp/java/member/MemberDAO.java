package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	//메서드 정의
	
	//DB연결
	private Connection getConnection() throws Exception {//예외처리 → 메서드 호출하는 곳에서 처리
		//드라이버 로더
		Class.forName("com.mysql.jdbc.Driver");
		//DB 서버 접속
		String dbUrl="jdbc:mysql://localhost:3306/jspdb3";
		String dbUser="root";
		String dbPass="1234";
		Connection con=DriverManager.getConnection(dbUrl,dbUser,dbPass);
		
		return con;
	}
	
	//insert
	public void insertMember(MemberBean mb) {
		
		try { //예외처리
			//연결 메서드 호출
			Connection con = getConnection();
			//sql문
			String sql="insert into member(id,pass,name,date) values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
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
		}
		
		return;
	}
	
	//info
	public MemberBean getMember(String id) {

		MemberBean mb = new MemberBean();
		
		try {
			
			Connection con = getConnection();
			
			String sql = "select * from member where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mb.setId(rs.getString("id"));
				mb.setPass(rs.getString("pass"));
				mb.setName(rs.getString("name"));
				mb.setDate(rs.getTimestamp("date"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return mb;
	}
	
	//login
	public MemberBean userCheck(String id, String pass) {
		
		MemberBean mb = null;
		
		try {
			Connection con = getConnection();
			
			String sql = "select * from member where id=? and pass=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
						
			ResultSet rs = pstmt.executeQuery();
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
			
		}
		
		return mb;
	}
	
	//update
	public void updateMember(MemberBean mb) {
		try {
			Connection con = getConnection();
			
			String sql = "update member set name=? where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,mb.getName());
			pstmt.setString(2,mb.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	//delete
	public void deleteMember(String id) {
		try {
			Connection con = getConnection();
			
			String sql = "delete from member where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	public List getMemberList() {
		
		List memberList = new ArrayList();
		
		try {
			Connection con = getConnection();
			String sql = "select * from member";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
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
			
		}
		return memberList;
	}
}
