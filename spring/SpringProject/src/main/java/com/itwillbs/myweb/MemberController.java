package com.itwillbs.myweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		// /WEB-INF/views/insertForm.jsp 이동
		return "insertForm";
	}
	
	@RequestMapping(value = "/insertPro", method = RequestMethod.POST)
	public String insertPro() {
		return "loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "loginForm";
	}
	
}
