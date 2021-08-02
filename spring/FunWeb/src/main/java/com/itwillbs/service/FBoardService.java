package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

public interface FBoardService {

	public void insertBoard(BoardBean bb);

	public List<BoardBean> getBoardList(PageBean pb);

	public Integer getBoardCount();

	public BoardBean getBoard(int num);

	public void updateBoard(BoardBean bb);

}
