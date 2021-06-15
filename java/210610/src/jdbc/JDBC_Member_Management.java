package jdbc;

import java.util.ArrayList;

public class JDBC_Member_Management {

	public JDBC_Member_Management() {
//		insert();
//		update();
		delete();
		select();
	}
	
	public void insert() {
		String name = "강감찬";
		int age = 45;
		String gender = "남";
		String jumin = "800808-1111222";
		
		MemberDTO dto = new MemberDTO(0, name, age, gender, jumin);
		MemberDAO dao = new MemberDAO();
		int count = dao.insert(dto);
		System.out.println(count + "명 insert 성공");
	}
	
	public void update() {
		String name = "이순신";
		String jumin = "701010-1233444";
		int age = 70;
		
		MemberDAO dao = new MemberDAO();
		int count = dao.update(name, jumin, age);
		System.out.println(count + "명 회원 수정 완료");
	}
	
	public void delete() {
		String name = "강감찬";
		int age = 30;
		
		MemberDAO dao = new MemberDAO();
		int count = dao.delete(name, age);
		System.out.println(count + "명 회원 삭제 완료");
	}
	
	public void select() {
		MemberDAO memberDAO = new MemberDAO();
		ArrayList<MemberDTO> memberList = memberDAO.select();
		
		for(int i=0; i<memberList.size(); i++) {
			MemberDTO memberDTO = memberList.get(i);
			System.out.println(memberDTO);
		}
		
		/*
		for(MemberDTO memberDTO : memberList) {
		
		}
		*/
		
	}
	
	public static void main(String[] args) {
		
		new JDBC_Member_Management();
		
	}

}
