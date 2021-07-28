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
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate(); // 세션값 초기화
		return "redirect:/main/main";
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		MemberBean mb = memberService.getMember(id);
		model.addAttribute("mb", mb);
		return "/member/update";
	}
	
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberBean mb, Model model) {
		MemberBean mb2 = memberService.userCheck(mb);
		if(mb2!=null) {
			memberService.updateMember(mb);
			return "redirect:/main/main";
		} else {
			model.addAttribute("msg", "입력하신 정보가 틀립니다");
			return "/member/msg";
		}
	}
	
}
