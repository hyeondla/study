package svc;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardBean;

import static db.JdbcUtil.*;

public class BoardDetailService {

	public BoardBean getArticle(int board_num) {
		System.out.println("BoardDetailService - getArticle()");
		BoardBean article = null;
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		article = boardDAO.selectArticle(board_num);
//		System.out.println(article.getBoard_subject());
		
//		if(article != null) {
//			int updateCount = boardDAO.updateReadCount(board_num);
//			if(updateCount > 0) {
//				System.out.println("조회수 증가 완료");
//				commit(con);
//			} else {
//				rollback(con);
//			}
//		}
		
		
		close(con);
		
		return article;
	}

	public void increaseReadcount(int board_num) {
		System.out.println("BoardDetailService - increaseReadcount()");
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int updateCount = boardDAO.updateReadCount(board_num);
		if(updateCount > 0) {
			System.out.println("조회수 증가 완료");
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
	}

}
