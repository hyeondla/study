package com.itwillbs.service;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.FBoardDAO;
import com.itwillbs.domain.BoardBean;

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

}
