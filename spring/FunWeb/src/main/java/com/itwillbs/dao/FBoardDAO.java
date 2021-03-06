package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

public interface FBoardDAO {

	public void insertBoard(BoardBean bb);

	public Integer getMaxNum();
	
	public List<BoardBean> getBoardList(PageBean pb);

	public Integer getBoardCount();
	
	public BoardBean getBoard(int num);
	
	public void updateBoard(BoardBean bb);
	
	public void deleteBoard(BoardBean bb);
	
	public List<BoardBean> getBoardListSearch(PageBean pb);

	public Integer getBoardCountSearch(PageBean pb);
	
	public void updateReadCount(int num);
	
}
