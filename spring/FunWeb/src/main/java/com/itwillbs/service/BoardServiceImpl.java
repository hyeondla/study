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
			bb.setRe_ref(1); // 답글 그룹번호 
		} else {
			bb.setNum(boardDAO.getMaxNum()+1);
			bb.setRe_ref(boardDAO.getMaxNum()+1); // 답글 그룹번호
		}
		
		bb.setReadcount(0);
		bb.setDate(new Timestamp(System.currentTimeMillis()));
		
		bb.setRe_lev(0); // 답글 들여쓰기
		bb.setRe_seq(0); // 답글 순서값
		
		boardDAO.insertBoard(bb);
	}
	
	@Override
	public void reInsertBoard(BoardBean bb) {
		
		if(boardDAO.getMaxNum()==null) {
			bb.setNum(1);
		} else {
			bb.setNum(boardDAO.getMaxNum()+1);
		}
		
		bb.setReadcount(0);
		bb.setDate(new Timestamp(System.currentTimeMillis()));
		
		// re_seq+1 -> re_ref 같은 그룹
		boardDAO.updateReseq(bb);
		
		// re_ref 그대로
		bb.setRe_lev(bb.getRe_lev()+1); // 답글 들여쓰기
		bb.setRe_seq(bb.getRe_seq()+1); // 답글 순서값
		
		
//		boardDAO.insertBoard(bb);
		boardDAO.reInsertBoard(bb);
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
