package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static db.JdbcUtil.*;
import vo.BoardBean;

public class BoardDAO {
	
	// 싱글톤 패턴
	
	// 인스턴스 생성 private static 으로 선언
//	private static BoardDAO instance = new BoardDAO();
	private static BoardDAO instance;

	// 외부에서 인스턴스 생성을 하지 못하도록 생성자를 private로 선언
	private BoardDAO() {}

	// getter -> 외부로 리턴
	public static BoardDAO getInstance() {
		// 인스턴스가 생성된 적이 없을 경우 생성 후 리턴
		if(instance == null) {
			instance = new BoardDAO();
		}
		
		return instance;
	}
	
	//------------------------------------------------------------
	
	Connection con;

	public void setConnection(Connection con) {
		this.con = con;
	}

	//============================================================

	public int insertArticle(BoardBean bb) {
		System.out.println("BoardDAO - insertArticle()");
		int insertCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// --------AUTO_INCREMENT 속성 사용 X----------
//		try {
//			int num = 1;
//			String sql = "SELECT MAX(board_num) FROM board";
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				num = rs.getInt("board_num") + 1;
//			}
//		} catch (SQLException e) {
////			e.printStackTrace();
//			System.out.println("SQL 구문 오류 발생 - " + e.getMessage());
//		} finally {
//			// 자원 반환
//			JdbcUtil.close(rs);
//			JdbcUtil.close(pstmt);
//			// !!!!! Connection 객체는 반환 X !!!!!
//		}
		
		// ----------AUTO_INCREMENT 속성 사용 O--------------
		
		try {
			int num = 1;
			String sql = "SHOW TABLE STATUS WHERE name='board'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt("Auto_increment"); // !!!!! 컬럼명 주의 !!!!! 또는 11 입력
//			System.out.println("새 글 번호 : " + num);
			}
		//-------------------------------------------------------------
			sql = "INSERT INTO board VALUES(?,?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, bb.getBoard_name());
			pstmt.setString(3, bb.getBoard_pass());
			pstmt.setString(4, bb.getBoard_subject());
			pstmt.setString(5, bb.getBoard_content());
			pstmt.setString(6, bb.getBoard_file_original());
			pstmt.setString(7, bb.getBoard_file_real());
			pstmt.setInt(8, num);  
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			pstmt.setInt(11, 0);

			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("SQL 구문 오류 발생 - " + e.getMessage());
		} finally {
			// 자원 반환
			close(rs);
			close(pstmt);
			// !!!!! Connection 객체는 반환 X !!!!!
		}
		
		
		return insertCount;
	}

	public int selectArticleListCount() {
		System.out.println("BoardDAO - selectArticleListCount()");
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(board_num) FROM board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("SQL 구문 오류 발생 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
		
	}

	public ArrayList<BoardBean> selectArticleList(int page, int limit) {
		
		ArrayList<BoardBean> articleList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int startRow = (page - 1) * limit;
		
		try {
			String sql = "SELECT * FROM board "
					+ "ORDER BY board_re_ref DESC,board_re_seq ASC "
					+ "LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();
			
			articleList = new ArrayList<BoardBean>();
			while(rs.next()) {
				BoardBean boardBean = new BoardBean();
				boardBean.setBoard_num(rs.getInt("board_num"));;
				boardBean.setBoard_name(rs.getString("board_name"));
				boardBean.setBoard_subject(rs.getString("board_subject"));
				boardBean.setBoard_content(rs.getString("board_content"));
				boardBean.setBoard_file_original(rs.getString("board_file_original"));
				boardBean.setBoard_file_real(rs.getString("board_file_real"));
				boardBean.setBoard_re_ref(rs.getInt("board_re_ref"));
				boardBean.setBoard_re_lev(rs.getInt("board_re_lev"));
				boardBean.setBoard_re_seq(rs.getInt("board_re_seq"));
				boardBean.setBoard_readcount(rs.getInt("board_readcount"));
				boardBean.setBoard_date(rs.getDate("board_date"));
				
				articleList.add(boardBean);
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("SQL 구문 오류 발생 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		} 
		
		return articleList;
	}

	public BoardBean selectArticle(int board_num) {
		BoardBean article = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM board WHERE board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				article = new BoardBean();
				article.setBoard_num(rs.getInt("board_num"));;
				article.setBoard_name(rs.getString("board_name"));
				article.setBoard_subject(rs.getString("board_subject"));
				article.setBoard_content(rs.getString("board_content"));
				article.setBoard_file_original(rs.getString("board_file_original"));
				article.setBoard_file_real(rs.getString("board_file_real"));
				article.setBoard_re_ref(rs.getInt("board_re_ref"));
				article.setBoard_re_lev(rs.getInt("board_re_lev"));
				article.setBoard_re_seq(rs.getInt("board_re_seq"));
				article.setBoard_readcount(rs.getInt("board_readcount"));
				article.setBoard_date(rs.getDate("board_date"));
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("SQL 구문 오류 발생 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return article;
	}

	public int updateReadCount(int board_num) {
		int readCount = 0;
		
		
		
		
		return readCount;
	}
	
}
