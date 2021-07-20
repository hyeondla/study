package dao;

import java.sql.Connection;

public class MemberDAO {
	
	private static MemberDAO instance = null;
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		if(instance == null) {
			return instance;
		}
		return instance;
	}
	
	Connection con;
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	
	
}
