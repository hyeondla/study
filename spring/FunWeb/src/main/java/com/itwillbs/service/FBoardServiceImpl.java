package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.FBoardDAO;
import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

@Service
public class FBoardServiceImpl implements FBoardService {

	@Inject
	private FBoardDAO fBoardDAO;
	
	@Override
	public void insertBoard(BoardBean bb) {
		
		if(fBoardDAO.getMaxNum()==null) {
			bb.setNum(1);
		} else {
			bb.setNum(fBoardDAO.getMaxNum()+1);
		}
		
		bb.setReadcount(0);
		bb.setDate(new Timestamp(System.currentTimeMillis()));
		
		fBoardDAO.insertBoard(bb);
	}

	@Override
	public List<BoardBean> getBoardList(PageBean pb) {
		return fBoardDAO.getBoardList(pb);
	}

	@Override
	public Integer getBoardCount() {
		return fBoardDAO.getBoardCount();
	}

	@Override
	public BoardBean getBoard(int num) {
		return fBoardDAO.getBoard(num);
	}

	@Override
	public void updateBoard(BoardBean bb) {
		fBoardDAO.updateBoard(bb);
	}

	@Override
	public void deleteBoard(BoardBean bb) {
		fBoardDAO.deleteBoard(bb);
	}

	@Override
	public List<BoardBean> getBoardListSearch(PageBean pb) {
		return fBoardDAO.getBoardListSearch(pb);
	}

	@Override
	public Integer getBoardCountSearch(PageBean pb) {
		return fBoardDAO.getBoardCountSearch(pb);
	}

	@Override
	public void updateReadCount(int num) {
		fBoardDAO.updateReadCount(num);
	}

}
