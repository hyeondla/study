package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberBean;
import com.itwillbs.service.MemberService;

@Controller
public class MemberController {

	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		return "/member/join";
	}
	
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberBean mb) {
		memberService.insertMember(mb);
		return "redirect:/member/login";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		return "/member/login";
	}
	
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberBean mb, Model model, HttpSession session) {
		MemberBean mb2 = memberService.userCheck(mb);
		if(mb2 != null) { // 로그인 성공
			//세션값 생성
			session.setAttribute("id", mb.getId());
			return "redirect:/main/main";
		} else { // 로그인 실패
			model.addAttribute("msg","일치하는 정보가 없습니다");
			return "/member/msg";
		}
	}
	
	@RequestMapping(value = "/main/main", method = RequestMethod.GET)
	public String main() {
		return "/main/main";
	}
	
	
}
