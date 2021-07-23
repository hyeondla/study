package com.itwillbs.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mapper.BoardMapper";
	
	@Override
	public void insertBoard(BoardBean bb) {
		System.out.println("BoardDAOImpl - insertBoard()");
		sqlSession.insert(namespace + ".insertBoard", bb);
	}

	@Override
	public Integer getMaxNum() {
		System.out.println("BoardDAOImpl - getMaxNum()");
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

}
