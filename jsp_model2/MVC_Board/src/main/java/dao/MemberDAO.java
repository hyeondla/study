package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.LoginFailException;
import vo.MemberBean;

import static db.JdbcUtil.*;

public class MemberDAO {
	
	private static MemberDAO instance = null;
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	Connection con;
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	
	
	public boolean selectLoginMember(String id, String password) throws LoginFailException {
		boolean isLoginSuccess = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT password FROM member WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
//				System.out.println("아이디 있음");
				if(password.equals(rs.getString("password"))) {
//					System.out.println("로그인 성공");
					isLoginSuccess = true;
				} else {
//					System.out.println("패스워드 틀림");
					throw new LoginFailException("패스워드 틀림");
				}
			} else {
//				System.out.println("아이디 없음");
				throw new LoginFailException("아이디 없음");
			}
			
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("MemberDAO - selectLoginMember 오류 : " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return isLoginSuccess;
	}
	
	public int insertMember(MemberBean memberBean) {
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO member VALUES(null,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberBean.getName());
			pstmt.setString(2, memberBean.getId());
			pstmt.setString(3, memberBean.getPassword());
			pstmt.setString(4, memberBean.getEmail());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("MemberDAO - insertMember 오류 : " + e.getMessage());
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	
	
}
