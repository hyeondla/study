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

	@Override
	public void finsertBoard(BoardBean bb) {
		sqlSession.insert(namespace + ".finsertBoard", bb);
	}

	@Override
	public Integer fgetMaxNum() {
		return sqlSession.selectOne(namespace+".fgetMaxNum");
	}
	
	@Override
	public List<BoardBean> fgetBoardList(PageBean pb) {
		return sqlSession.selectList(namespace+".fgetBoardList", pb);
	}

	@Override
	public Integer fgetBoardCount() {
		return sqlSession.selectOne(namespace+".fgetBoardCount");
	}
	
	@Override
	public BoardBean fgetBoard(int num) {
		return sqlSession.selectOne(namespace+".fgetBoard", num);
	}

	@Override
	public BoardBean numCheck(BoardBean bb) {
		return sqlSession.selectOne(namespace + ".numCheck", bb);
	}

	@Override
	public void updaeteBoard(BoardBean bb) {
		sqlSession.update(namespace + ".updateBoard", bb);
	}

	@Override
	public void deleteBoard(BoardBean bb) {
		sqlSession.delete(namespace + ".deleteBoard", bb);
	}
}
