package com.itwillbs.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberBean;

@Service
public class MemberServiceImpl implements MemberService {
	// MemberDAOImpl 의존 관계
	
	// 멤버변수 정의
	private MemberDAO memberDAO;
	// set 메서드를 통해서 값 전달
	@Inject
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	} 
	
	@Override
	public void insertMember(MemberBean mb) {
		System.out.println("MemberServiceImpl - insertMember()");
		
		// 1) 자바 파일 하나로 객체 생성
//		MemberDAOImpl memberDAO = new MemberDAOImpl();
//		memberDAO.insertMember(mb);
		
		// 2) 부모인터페이스 추상메서드 => 상속받은 클래스 객체 생성
//	    부모 = 자식객체 (업캐스팅)
//		MemberDAO memberDAO = new MemberDAOImpl();
//		memberDAO.insertMember(mb);
		
		// 3) 스프링파일(xml)에서 자식클래스 객체 생성
		memberDAO.insertMember(mb);
	}

	@Override
	public MemberBean userCheck(MemberBean mb) {
		System.out.println("MemberServiceImpl - userCheck");
		return memberDAO.userCheck(mb);
	}

	@Override
	public MemberBean getMember(String id) {
		System.out.println("MemberServiceImpl - getMember");
		return memberDAO.getMember(id);
	}

	@Override
	public void updateMember(MemberBean mb) {
		System.out.println("MemberServiceImpl - updateMember");
		memberDAO.updateMember(mb);
	}

	@Override
	public void deleteMember(MemberBean mb) {
		System.out.println("MemberServiceImpl - deleteMember");
		memberDAO.deleteMember(mb);
	}
	
	

	
	
	
}
