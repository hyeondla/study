package com.itwillbs.myweb;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberBean;
import com.itwillbs.service.MemberServiceImpl;

@Controller
public class MemberController {

	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
	//  /WEB-INF/views/insertForm.jsp 이동
		return "insertForm";
	}
	
	@RequestMapping(value = "/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberBean mb) {
		System.out.println("MemberController /insertPro");
		
		// ------- HttpServletRequest request 를 매개변수로 받았을 때 ------------
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("pass"));
//		System.out.println(request.getParameter("name"));
		
		// request 내장객체 파라미터값
		// => 자바빈 객체의 변수에 저장
		
//		MemberBean mb = new MemberBean();
//		mb.setId(request.getParameter("id"));
//		mb.setPass(request.getParameter("pass"));
//		mb.setName(request.getParameter("name"));
		// ------------------------------------------------------------------------		
		
		// ------- MemberBean mb 를 매개변수로 받았을 때 ------------
		// 폼의 파라미터 이름과 자바빈의 변수 이름이 일치하면 자동으로 저장됨
		System.out.println(mb.getId());
		System.out.println(mb.getPass());
		System.out.println(mb.getName());
		// ----------------------------------------------------------
		
		// 회원가입 처리
		MemberServiceImpl memberService = new MemberServiceImpl();
		memberService.insertMember(mb);
		
	//  /WEB-INF/views/loginForm.jsp 이동
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "loginForm";
	}
	
	@RequestMapping(value = "/loginPro", method = RequestMethod.POST)
	public String loginPro() {
		System.out.println("MemberController /loginPro");
		// 로그인 처리
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		return "main";
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info() {
		return "info";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update() {
		return "updateForm";
	}
	
	@RequestMapping(value = "/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberBean mb) {
		System.out.println("MemberController /updatePro");
		// 업데이트 처리
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
		return "deleteForm";
	}
	
	@RequestMapping(value = "/deletePro", method = RequestMethod.POST)
	public String deletePro(MemberBean mb) {
		System.out.println("MemberController /deletePro");
		// 삭제 처리
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "list";
	}
	
}
