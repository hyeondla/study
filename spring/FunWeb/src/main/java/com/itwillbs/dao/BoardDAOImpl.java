package com.itwillbs.dao;

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
	
	private static final String namespace = "com.itwillbs.mapper.BoardMapper";
	
	@Override
	public List<BoardBean> getBoardList(PageBean pb) {
		return sqlSession.selectList(namespace + ".getBoardList", pb);
	}

	@Override
	public Integer getBoardCount() {
		return sqlSession.selectOne(namespace + ".getBoardCount");
	}

	@Override
	public List<BoardBean> getBoardListSearch(PageBean pb) {
		return sqlSession.selectList(namespace + ".getBoardListSearch", pb);
	}

	@Override
	public Integer getBoardCountSearch(PageBean pb) {
		return sqlSession.selectOne(namespace + ".getBoardCountSearch", pb);
	}

}
