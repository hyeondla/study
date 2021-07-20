package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
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
		
		return "/member/insertForm";
	}
	
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberBean mb) {
		
		memberService.insertMember(mb);
		
		return "redirect:/member/login";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		
		return "/member/loginForm";
	}
	
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberBean mb, HttpSession session, Model model) {
		
		MemberBean mb2 = memberService.userCheck(mb);
		if(mb2 != null) {
			session.setAttribute("id", mb.getId());
			return "redirect:/member/main";
		} else {
			model.addAttribute("msg", "입력하신 정보가 틀립니다");
			return "/member/msg";
		}
		
	}
	
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {

		return "/member/main";
	}
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/member/main";
	}
	
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info(HttpSession session, Model model) {
		
		String id= (String)session.getAttribute("id");
		MemberBean mb = memberService.getMember(id);
		model.addAttribute("mb", mb);
		
		return "/member/info";
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		
		String id= (String)session.getAttribute("id");
		MemberBean mb = memberService.getMember(id);
		model.addAttribute("mb", mb);
		
		return "/member/updateForm";
	}
	
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberBean mb, HttpSession session, Model model) {
		
		MemberBean mb2 = memberService.userCheck(mb);
		if(mb2 != null) {
			memberService.updateMember(mb);
			return "redirect:/member/main";
		} else {
			model.addAttribute("msg", "입력하신 정보가 틀립니다");
			return "/member/msg";
		}
		
	}
	
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		
		return "/member/deleteForm";
	}
	
	@RequestMapping(value = "/member/deletePro", method = RequestMethod.POST)
	public String deletePro(MemberBean mb, HttpSession session, Model model) {
		
		MemberBean mb2 = memberService.userCheck(mb);
		if(mb2 != null) {
			memberService.deleteMember(mb);
			session.invalidate();
			return "redirect:/member/main";
		} else {
			model.addAttribute("msg", "입력하신 정보가 틀립니다");
			return "/member/msg";
		}
		
	}
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list(HttpSession session, Model model) {
		
		List<MemberBean> mbList = memberService.getMemberList();
		model.addAttribute("mbList", mbList);
		
		return "/member/list";
	}
	
}
