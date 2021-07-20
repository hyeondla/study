package svc;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardBean;

import static db.JdbcUtil.*;

public class BoardModifyProService {

	public boolean isArticleWrite(int board_num, String board_pass) {
		System.out.println("BoardModifyProService - isArticleWrite");
		boolean isRightUser = false;
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		isRightUser = boardDAO.isArticleWriter(board_num, board_pass);
		
		
		close(con);
		
		return isRightUser;
	}

	public boolean modifyArticle(BoardBean article) {
		boolean isModifySuccess = false;
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int updateCount = boardDAO.updateArticle(article);
		
		if(updateCount > 0) {
			commit(con);
			isModifySuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isModifySuccess;
	}

}
