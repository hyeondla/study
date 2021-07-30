package com.itwillbs.service;

import java.sql.Timestamp;
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

	@Override
	public void insertBoard(BoardBean bb) {
		
		if(boardDAO.getMaxNum()==null) {
			bb.setNum(1);
		} else {
			bb.setNum(boardDAO.getMaxNum()+1);
		}
		
		bb.setReadcount(0);
		bb.setDate(new Timestamp(System.currentTimeMillis()));
		
		boardDAO.insertBoard(bb);
	}

	@Override
	public BoardBean getBoard(int num) {
		return boardDAO.getBoard(num);
	}

	@Override
	public void updateBoard(BoardBean bb) {
		boardDAO.updateBoard(bb);
	}

	@Override
	public void updateReadCount(int num) {
		boardDAO.updateReadCount(num);
	}

	@Override
	public void deleteBoard(BoardBean bb) {
		boardDAO.deleteBoard(bb);
	}

}
