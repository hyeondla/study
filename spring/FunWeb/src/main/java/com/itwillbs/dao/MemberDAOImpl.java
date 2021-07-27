package com.itwillbs.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberBean;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.itwillbs.mapper.MemberMapper";
	
	@Override
	public void insertMember(MemberBean mb) {
		sqlSession.insert(namespace + ".insertMember", mb);
	}

	@Override
	public MemberBean userCheck(MemberBean mb) {
		return sqlSession.selectOne(namespace + ".userCheck", mb);
	}

}
