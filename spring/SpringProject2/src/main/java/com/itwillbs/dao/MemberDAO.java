package com.itwillbs.dao;

import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberBean;

@Repository
public interface MemberDAO {

	public void insertMember(MemberBean mb);
	
	public MemberBean userCheck(MemberBean mb);
	
	public MemberBean getMember(String id);
	
}
