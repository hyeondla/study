package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

public interface BoardService {

	public List<BoardBean> getBoardList(PageBean pb);

	public Integer getBoardCount();

	public List<BoardBean> getBoardListSearch(PageBean pb);

	public Integer getBoardCountSearch(PageBean pb);

	public void insertBoard(BoardBean bb);

	public BoardBean getBoard(int num);

	public void updateBoard(BoardBean bb);

	public void updateReadCount(int num);

	public void deleteBoard(BoardBean bb);

}
