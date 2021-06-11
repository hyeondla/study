package fboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FileBoardDAO {
	
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/MysqlDB"); //다운캐스팅
		Connection con = ds.getConnection();
		return con;
	}
	
	public void finsertBoard(FileBoardBean bb) {
	
		Connection con = null;
		PreparedStatement pstmtnum = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			int num=0;
			String sqlnum = "select max(num) from fboard";
			pstmtnum = con.prepareStatement(sqlnum);
			rs = pstmtnum.executeQuery();
			if(rs.next()){
				num=rs.getInt("max(num)")+1;
				bb.setNum(num);
			}
			
			String sql = "insert into fboard(num,name,pass,subject,content,readcount,date,file) values(?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bb.getNum());
			pstmt.setString(2, bb.getName());
			pstmt.setString(3, bb.getPass());
			pstmt.setString(4, bb.getSubject());
			pstmt.setString(5, bb.getContent());
			pstmt.setInt(6, bb.getReadcount());
			pstmt.setTimestamp(7, bb.getDate());
			pstmt.setString(8, bb.getFile()); // 파일 추가

			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//기억장소 해제
			if(rs != null) {
				try { rs.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
			if(pstmtnum != null) {
				try { pstmtnum.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
			if(con != null) {
				try { con.close(); } catch (SQLException ex) { ex.printStackTrace(); }
			}
		}
	}
	
	/*
	public FileBoardBean getBoard(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FileBoardBean bb = null;
		try {
			con = getConnection();
			
			String sql = "select * from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				bb = new FileBoardBean();
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
		return bb;
	}
	*/
	/*
	public void updateReadcount(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "update board set readcount=readcount+1 where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
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
	*/
	/*
	public FileBoardBean numCheck(int num, String pass) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		FileBoardBean bb = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from board where num=? and pass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, pass);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				bb = new FileBoardBean();
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
		return bb;
	}
	*/
	/*
	public void updateBoard(FileBoardBean bb) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "update board set subject=?, content=? where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bb.getSubject());
			pstmt.setString(2, bb.getContent());
			pstmt.setInt(3, bb.getNum());
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
	*/
	/*
	public void deleteBoard(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "delete from board where num=?";
		  	pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
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
	*/
	/*
	public List<BoardBean> getBoardList() {
		
		List<BoardBean> boardList = new ArrayList<BoardBean>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		
		try {
			con = getConnection();
			String sql = "select * from board order by num desc"; 
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
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
		return boardList;
	}
	*/
	/*
	public List<FileBoardBean> getBoardList(int startRow, int pageSize) {
		
		List<FileBoardBean> boardList = new ArrayList<FileBoardBean>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		
		try {
			con = getConnection();
			String sql = "select * from board order by num desc limit ?, ?"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FileBoardBean bb = new FileBoardBean();
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
		return boardList;
	}
	*/
	/*
	public int getCount() {
		
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
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
				
		return count;
	}
	*/
}
