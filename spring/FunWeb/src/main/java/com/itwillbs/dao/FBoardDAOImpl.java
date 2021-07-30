package com.itwillbs.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardBean;

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



}
