package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.MemberBean;
import com.itwillbs.domain.PageBean;
import com.itwillbs.service.BoardService;
import com.itwillbs.service.MemberService;

@RestController
public class AjaxController {
	
	@Inject
	private MemberService memberService;
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/member/idcheck", method = RequestMethod.GET)
	public ResponseEntity<String> idcheck(HttpServletRequest request) {
		String result = "";
		ResponseEntity<String> entity = null;
		try {
			String id = request.getParameter("id");
			MemberBean mb = memberService.getMember(id);
			if(mb != null) { // 아이디 중복
				result = "iddup";
			} else { // 사용가능
				result = "idok";
			}
			entity = new ResponseEntity<String>(result,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/board/ajaxlist", method = RequestMethod.GET)
	public ResponseEntity<List<BoardBean>> ajaxlist() {
		ResponseEntity<List<BoardBean>> entity = null;
		try {
			PageBean pb = new PageBean();
			pb.setPageNum("1");
			pb.setPageSize(5);
			List<BoardBean> bbList = boardService.getBoardList(pb);
			entity = new ResponseEntity<List<BoardBean>>(bbList,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<BoardBean>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
