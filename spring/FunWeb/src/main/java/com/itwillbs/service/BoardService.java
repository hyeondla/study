package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

public interface BoardService {

	public List<BoardBean> getBoardList(PageBean pb);

	public Integer getBoardCount();

	public List<BoardBean> getBoardListSearch(PageBean pb);

	public Integer getBoardCountSearch(PageBean pb);

}
