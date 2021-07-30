package com.itwillbs.controller;

import javax.servlet.http.HttpServletRequest;

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
	public String test2(HttpServletRequest request, Model model) {
		String q1 = request.getParameter("q1");
//		System.out.println(request.getParameter("q1"));
		model.addAttribute("q1", q1);
		return "/test/test2";
	}
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String test3(HttpServletRequest request, Model model) {
		String q1 = request.getParameter("q1");
		String q2 = request.getParameter("q2");
//		System.out.println(request.getParameter("q1"));
//		System.out.println(request.getParameter("q2"));
		model.addAttribute("q1", q1);
		model.addAttribute("q2", q2);
		return "/test/test3";
	}
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public String test4(HttpServletRequest request, Model model) {
		String q1 = request.getParameter("q1");
		String q2 = request.getParameter("q2");
		String q3 = request.getParameter("q3");
//		System.out.println(request.getParameter("q1"));
//		System.out.println(request.getParameter("q2"));
//		System.out.println(request.getParameter("q3"));
		model.addAttribute("q1", q1);
		model.addAttribute("q2", q2);
		model.addAttribute("q3", q3);
		return "/test/test4";
	}
}
