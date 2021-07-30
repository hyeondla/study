package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;
import com.itwillbs.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {
		PageBean pb = new PageBean();
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pb.setPageNum("1");
		} else {
			pb.setPageNum(pageNum);
		}
		int pageSize = 15;
		pb.setPageSize(pageSize);
		List<BoardBean> bbList = boardService.getBoardList(pb);
		
		// 전체 글 개수
		pb.setCount(boardService.getBoardCount());
		
		model.addAttribute("bbList", bbList);
		model.addAttribute("pb", pb);
		
		return "/center/notice";
	}
	
	@RequestMapping(value = "/board/listSearch", method = RequestMethod.POST)
	public String listSearch(HttpServletRequest request, Model model) {
		PageBean pb = new PageBean();
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pb.setPageNum("1");
		} else {
			pb.setPageNum(pageNum);
		}
		int pageSize = 15;
		pb.setPageSize(pageSize);
		
		// 검색 
		String search = request.getParameter("search");
		pb.setSearch(search);
		List<BoardBean> bbList = boardService.getBoardListSearch(pb);
		
		// 전체 글 개수
		pb.setCount(boardService.getBoardCountSearch(pb));
		
		model.addAttribute("bbList", bbList);
		model.addAttribute("pb", pb);
		
		return "/center/noticeSearch";
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write() {
		return "/center/write";
	}
	
	@RequestMapping(value = "/board/writePro", method = RequestMethod.POST)
	public String writePro(BoardBean bb) {
		
		boardService.insertBoard(bb);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/board/content", method = RequestMethod.GET)
	public String content(HttpServletRequest request, Model model) {
		int num = Integer.parseInt(request.getParameter("num"));
		boardService.updateReadCount(num); // 조회수 증가
		BoardBean bb = boardService.getBoard(num);
		model.addAttribute("bb", bb);
		return "/center/content";
	}
	
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		int num = Integer.parseInt(request.getParameter("num"));
		BoardBean bb = boardService.getBoard(num);
		model.addAttribute("bb", bb);
		return "/center/update";
	}
	@RequestMapping(value = "/board/updatePro", method = RequestMethod.POST)
	public String updatePro(BoardBean bb) {
		boardService.updateBoard(bb);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model) {
		int num = Integer.parseInt(request.getParameter("num"));
		model.addAttribute("num", num);
		return "/center/delete";
	}
	@RequestMapping(value = "/board/deletePro", method = RequestMethod.POST)
	public String deletePro(BoardBean bb) {
		boardService.deleteBoard(bb);
		return "redirect:/board/list";
	}
	
}
