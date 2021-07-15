package svc;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardBean;

import static db.JdbcUtil.*;

public class BoardModifyProService {

	public Boolean isArticleWrite(int board_num, String board_pass) {
		System.out.println("BoardModifyProService - isArticleWrite");
		Boolean isRightUser = false;
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		isRightUser = boardDAO.isArticleWriter(board_num, board_pass);
		
		
		close(con);
		
		return isRightUser;
	}

	public boolean modifyArticle(BoardBean article) {
		Boolean isModifySuccess = false;
		
		
		
		return isModifySuccess;
	}

}
