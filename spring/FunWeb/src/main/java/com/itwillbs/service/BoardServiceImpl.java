package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.BoardDAO;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardBean> getBoardList(PageBean pb) {
		
		pb.setCurrentPage(Integer.parseInt(pb.getPageNum()));
		pb.setStartRow((pb.getCurrentPage()-1)*pb.getPageSize()+1-1);
		
		return boardDAO.getBoardList(pb);
	}

	@Override
	public Integer getBoardCount() {
		return boardDAO.getBoardCount();
	}

	@Override
	public List<BoardBean> getBoardListSearch(PageBean pb) {
		
		pb.setCurrentPage(Integer.parseInt(pb.getPageNum()));
		pb.setStartRow((pb.getCurrentPage()-1)*pb.getPageSize()+1-1);
		
		return boardDAO.getBoardListSearch(pb);
	}

	@Override
	public Integer getBoardCountSearch(PageBean pb) {
		return boardDAO.getBoardCountSearch(pb);
	}

}
