package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;

public class BoardDeleteProService {

	public boolean isArticleWriter(int board_num, String board_pass) {
		
		System.out.println("BoardDeleteProService - isArticleWriter");
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		boolean isRightUser = boardDAO.isArticleWriter(board_num, board_pass);
		
		close(con);
		
		return isRightUser;
		
	}

	public boolean removeArticle(int board_num) {
		
		System.out.println("BoardDeleteProService - removeArticle");
		
		boolean isDeleteSuccess = false;
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int deleteCount = boardDAO.deleteArticle(board_num);
		
		if(deleteCount > 0) {
			commit(con);
			isDeleteSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isDeleteSuccess;
	}
	
}
