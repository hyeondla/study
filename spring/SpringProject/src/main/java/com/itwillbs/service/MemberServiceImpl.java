package com.itwillbs.service;

import com.itwillbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberBean;

public class MemberServiceImpl { 
	// MemberDAOImpl 의존 관계
	
	public void insertMember(MemberBean mb) {
		System.out.println("MemberServiceImpl - insertMember()");
		MemberDAOImpl memberDAO = new MemberDAOImpl();
		memberDAO.insertMember(mb);
	
	}
	
}
