package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

@Repository
public class FBoardDAOImpl implements FBoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mapper.FBoardMapper";

	@Override
	public void insertBoard(BoardBean bb) {
		sqlSession.insert(namespace + ".insertBoard", bb);
	}

	@Override
	public Integer getMaxNum() {
		return sqlSession.selectOne(namespace + ".getMaxNum");
	}

	@Override
	public List<BoardBean> getBoardList(PageBean pb) {
		return sqlSession.selectList(namespace + ".getBoardList", pb);
	}

	@Override
	public Integer getBoardCount() {
		return sqlSession.selectOne(namespace + ".getBoardCount");
	}

	@Override
	public BoardBean getBoard(int num) {
		return sqlSession.selectOne(namespace + ".getBoard", num);
	}

	@Override
	public void updateBoard(BoardBean bb) {
		sqlSession.update(namespace + ".updateBoard", bb);
	}



}
