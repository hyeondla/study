package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.JdbcUtil;
import vo.BoardBean;

public class BoardDAO {
	
	// 싱글톤 패턴
	
	// 인스턴스 생성 private static 으로 선언
//	private static BoardDAO instance = new BoardDAO();
	private static BoardDAO instance;

	// 외부에서 인스턴스 생성을 하지 못하도록 생성자를 private로 선언
	private BoardDAO() {}

	// getter -> 외부로 리턴
	public static BoardDAO getBdao() {
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
		System.out.println("BoardDAO - insertArticle");
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
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			// !!!!! Connection 객체는 반환 X !!!!!
		}
		
		
		return insertCount;
	}
	
}
