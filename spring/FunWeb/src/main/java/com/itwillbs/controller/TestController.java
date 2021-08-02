package com.itwillbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test1() {
		return "/test/test1";
	}
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2(HttpServletRequest request, HttpSession session) {
		// /test2?q1=(값) 가져옴 
		String q1 = request.getParameter("q1"); // 가져온 값을 저장
		session.setAttribute("q1", q1); // -> 세션에 저장 
		return "/test/test2";
	}
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String test3(HttpServletRequest request, HttpSession session) {
		String q2 = request.getParameter("q2");
		session.setAttribute("q2", q2);
		return "/test/test3";
	}
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public String test4(HttpServletRequest request, HttpSession session) {
		String q3 = request.getParameter("q3");
		session.setAttribute("q3", q3);
		return "/test/test4";
	}
}
