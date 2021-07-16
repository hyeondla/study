package com.itwillbs.service;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberBean;

@Service
public interface MemberService {

	public void insertMember(MemberBean mb);

}
