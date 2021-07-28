package com.itwillbs.service;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberBean;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO memberDAO;
	
	@Override
	public void insertMember(MemberBean mb) {
		mb.setDate(new Timestamp(System.currentTimeMillis()));
		memberDAO.insertMember(mb);
	}

	@Override
	public MemberBean userCheck(MemberBean mb) {
		return memberDAO.userCheck(mb);
	}

	@Override
	public MemberBean getMember(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public void updateMember(MemberBean mb) {
		memberDAO.updateMember(mb);
	}

}
