package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReBoardDAO {
	
	private Connection getConnection() throws Exception{
		Context init=new InitialContext();
		DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
		Connection con=ds.getConnection();
		return con;
	}
	
	public void insertReBoard(ReBoardBean rb) {
		Connection con=null;
		PreparedStatement pstmt2=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		try {
			 con=getConnection();
			
			 int num=0;
			 String sql2="select max(num) from reboard";
			 pstmt2=con.prepareStatement(sql2);
			 rs=pstmt2.executeQuery();
			 if(rs.next()){
			 	num=rs.getInt("max(num)")+1;
			 }
			 String sql="insert into reboard(num,name,content,date,board_num) values(?,?,?,?,?)";
			 pstmt=con.prepareStatement(sql);
			 pstmt.setInt(1, num);
			 pstmt.setString(2, rb.getName());
			 pstmt.setString(3, rb.getContent());
			 pstmt.setTimestamp(4, rb.getDate());
			 pstmt.setInt(5, rb.getBoard_num());

			 pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex) {}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex) {}
			if(pstmt2!=null) try{pstmt2.close();}catch(SQLException ex) {}
			if(con!=null) try{con.close();}catch(SQLException ex) {}
		}
	}
	
	
	
	
}
