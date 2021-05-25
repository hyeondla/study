package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	
	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		String dbUrl="jdbc:mysql://localhost:3306/jspdb3";
		String dbUser="root";
		String dbPass="1234";
		Connection con=DriverManager.getConnection(dbUrl,dbUser,dbPass);
		
		return con;
	}
	
	public void insertBoard(BoardBean bb) {
		try {
			Connection con = getConnection();
			
			int num=0;
			String sqlnum = "select max(num) from board";
			PreparedStatement pstmtnum = con.prepareStatement(sqlnum);
			ResultSet rs = pstmtnum.executeQuery();
			if(rs.next()){
				num=rs.getInt("max(num)")+1;
				bb.setNum(num);
			}
			
			String sql = "insert into board(num,name,pass,subject,content,readcount,date) values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bb.getNum());
			pstmt.setString(2, bb.getName());
			pstmt.setString(3, bb.getPass());
			pstmt.setString(4, bb.getSubject());
			pstmt.setString(5, bb.getContent());
			pstmt.setInt(6, bb.getReadcount());
			pstmt.setTimestamp(7, bb.getDate());

			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	public BoardBean getBoard(int num) {
		BoardBean bb = null;
		try {
			Connection con = getConnection();
			
			String sql = "select * from board where num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				bb = new BoardBean();
				bb.setNum(num);
				bb.setName(rs.getString("name"));
				bb.setDate(rs.getTimestamp("date"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setSubject(rs.getString("subject"));
				bb.setContent(rs.getString("content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return bb;
	}
	
	public void updateReadcount(int num) {
		try {
			Connection con = getConnection();
			String sql = "update board set readcount=readcount+1 where num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	public BoardBean numCheck(int num, String pass) {
		BoardBean bb = null;
		try {
			Connection con = getConnection();
			
			String sql = "select * from board where num=? and pass=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, pass);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				bb = new BoardBean();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return bb;
	}
	
	public void updateBoard(BoardBean bb) {
		try {
			Connection con = getConnection();
			
			String sql = "update board set subject=?, content=? where num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bb.getSubject());
			pstmt.setString(2, bb.getContent());
			pstmt.setInt(3, bb.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	public void deleteBoard(int num) {
		try {
			Connection con = getConnection();
			String sql = "delete from board where num=?";
		  	PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	public List getBoardList() {
		
		List boardList = new ArrayList();
		
		try {
			Connection con = getConnection();
			String sql = "select * from board order by num desc"; 
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardBean bb = new BoardBean();
				bb.setNum(rs.getInt("num"));
				bb.setName(rs.getString("name"));
				bb.setPass(rs.getString("pass"));
				bb.setSubject(rs.getString("subject"));
				bb.setContent(rs.getString("content"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setDate(rs.getTimestamp("date"));
				
				boardList.add(bb); //배열에 순서대로 저장
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return boardList;
	}
	
}
