package com.itwillbs.dao;

import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberBean;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Override
	public void insertMember(MemberBean mb) {
		System.out.println("MemberDAOImpl - insertMember");
	}

}
