package com.itwillbs.dao;

import com.itwillbs.domain.BoardBean;

public interface FBoardDAO {

	public void insertBoard(BoardBean bb);

	public Integer getMaxNum();
	
	
	
}
