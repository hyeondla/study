package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
//import db.JdbcUtil;
import vo.BoardBean;

//import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.*;

public class BoardListService {

	public int getListCount() {
//		System.out.println("BoardListService - getListCount()");
		int listCount = 0;
		
		// Connection 객체 가져오기
//		Connection con = JdbcUtil.getConnection();
		Connection con = getConnection();
		// BoardDAO 객체 가져오기
		BoardDAO boardDAO = BoardDAO.getInstance();
		// BoardDAO 객체에 Connection 객체 전달하기
		boardDAO.setConnection(con);
		
		listCount = boardDAO.selectArticleListCount();
		
		
		
		
//		JdbcUtil.close(con);
		close(con);
		
		return listCount;
	}

	public ArrayList<BoardBean> getArticleList(int page, int limit) {
//		System.out.println("BoardListService - getArticleList()");
		
		ArrayList<BoardBean> articleList = null;
		
//		Connection con = JdbcUtil.getConnection();
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		articleList = boardDAO.selectArticleList(page, limit);
		
//		JdbcUtil.close(con);
		close(con);
		
		return articleList;
	}

}
