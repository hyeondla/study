package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

public interface BoardDAO {

	public void insertBoard(BoardBean bb);
	
	public Integer getMaxNum();
	
	public List<BoardBean> getBoardList(PageBean pb);
	
	public Integer getBoardCount();
	
	public BoardBean getBoard(int num);
	
	public void finsertBoard(BoardBean bb);
	
	public Integer fgetMaxNum();
	
	public List<BoardBean> fgetBoardList(PageBean pb);

	public Integer fgetBoardCount();
	
	public BoardBean fgetBoard(int num);
	
}
