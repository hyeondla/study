package svc;

import java.sql.Connection;

import dao.MemberDAO;

import static db.JdbcUtil.*;

public class MemberLoginProService {

	public boolean login(String id, String password) {
		boolean isLoginSuccess = false;
		
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		
		
		
		close(con);
		
		return isLoginSuccess;
	}

}
