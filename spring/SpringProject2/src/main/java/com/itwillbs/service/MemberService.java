package com.itwillbs.service;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberBean;

@Service
public interface MemberService {

	public void insertMember(MemberBean mb);
	
	public MemberBean userCheck(MemberBean mb);

	public MemberBean getMember(String id);
	
}
