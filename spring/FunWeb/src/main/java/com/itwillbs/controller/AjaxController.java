package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.MemberBean;
import com.itwillbs.service.MemberService;

@RestController
public class AjaxController {

	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/member/idcheck", method = RequestMethod.GET)
	public ResponseEntity<String> idcheck(HttpServletRequest request) {
		ResponseEntity<String> entity = null;
		String result = "";
		try {
			String id = (String)request.getParameter("id");
			MemberBean mb = memberService.getMember(id);
			if(mb!=null) {
				result = "iddup";
			} else {
				result = "idok";
			}
			entity = new ResponseEntity<String>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}
