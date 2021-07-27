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
	public void insertBoard(BoardBean bb) {
		bb.setReadcount(0);
		bb.setDate(new Timestamp(System.currentTimeMillis()));
		
		if(boardDAO.getMaxNum() == null) { // 게시판 글이 없는 경우
			bb.setNum(1);
		} else {
			bb.setNum(boardDAO.getMaxNum() + 1);
		}
		
		
		boardDAO.insertBoard(bb);
	}

	@Override
	public List<BoardBean> getBoardList(PageBean pb) {
		// 페이지 처리
		pb.setCurrentPage(Integer.parseInt(pb.getPageNum()));
		pb.setStartRow(((pb.getCurrentPage()-1)*pb.getPageSize()+1)-1);
		pb.setEndRow(pb.getStartRow()+pb.getPageSize()-1);
		
		return boardDAO.getBoardList(pb);
	}

	@Override
	public Integer getBoardCount() {
		return boardDAO.getBoardCount();
	}

	@Override
	public BoardBean getBoard(int num) {
		return boardDAO.getBoard(num);
	}

	@Override
	public void finsertBoard(BoardBean bb) {
		
		if(boardDAO.fgetMaxNum() == null) {
			bb.setNum(1);
		} else {
			bb.setNum(boardDAO.fgetMaxNum()+1);
		}
		
		bb.setReadcount(0);
		bb.setDate(new Timestamp(System.currentTimeMillis()));
		
		boardDAO.finsertBoard(bb);
	}

	@Override
	public List<BoardBean> fgetBoardList(PageBean pb) {
		pb.setCurrentPage(Integer.parseInt(pb.getPageNum()));
		pb.setStartRow((pb.getCurrentPage()-1)*pb.getPageSize()+1-1);
		
		return boardDAO.fgetBoardList(pb);
	}

	@Override
	public Integer fgetBoardCount() {
		return boardDAO.fgetBoardCount();
	}
	
	@Override
	public BoardBean fgetBoard(int num) {
		return boardDAO.fgetBoard(num);
	}

	@Override
	public BoardBean numCheck(BoardBean bb) {
		return boardDAO.numCheck(bb);
	}

	@Override
	public void updaeteBoard(BoardBean bb) {
		boardDAO.updaeteBoard(bb);
	}

	@Override
	public void deleteBoard(BoardBean bb) {
		boardDAO.deleteBoard(bb);
	}
	
}
