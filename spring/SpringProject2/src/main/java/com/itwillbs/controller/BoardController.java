package com.itwillbs.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;
import com.itwillbs.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String insert() {
		
		return "/board/writeForm";
	}
	
	@RequestMapping(value = "/board/writePro", method = RequestMethod.POST)
	public String insertPro(BoardBean bb) {
		
		boardService.insertBoard(bb);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request) {
		
		PageBean pb = new PageBean();
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) { pageNum = "1"; }
		pb.setPageNum(pageNum);
		
		int pageSize = 10;
		pb.setPageSize(pageSize);
		
		List<BoardBean> bbList = boardService.getBoardList(pb);
		
		pb.setCount(boardService.getBoardCount());
		
		model.addAttribute("bbList", bbList);
		model.addAttribute("pb", pb);
		
		return "/board/list";
	}
	
	@RequestMapping(value = "/board/content", method = RequestMethod.GET)
	public String content(Model model, HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		BoardBean bb = boardService.getBoard(num);
		model.addAttribute("bb", bb);
		return "/board/content";
	}
	
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String update(Model model, HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		BoardBean bb = boardService.getBoard(num);
		model.addAttribute("bb", bb);
		return "/board/updateForm";
	}
	
	@RequestMapping(value = "/board/updatePro", method = RequestMethod.POST)
	public String updatePro(BoardBean bb, Model model) {
		
		BoardBean bb2 = boardService.numCheck(bb);
		if(bb2!=null) { // num pass 일치
			boardService.updaeteBoard(bb); // 수정
			return "redirect:/board/list";
		} else { // 불일치
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다");
			return "/board/msg";
		}
		
	}
	
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public String delete(Model model, HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		model.addAttribute("num", num);
		
		return "/board/deleteForm";
	}
	
	@RequestMapping(value = "/board/deletePro", method = RequestMethod.POST)
	public String deletePro(BoardBean bb, Model model) {
		
		BoardBean bb2 = boardService.numCheck(bb);
		if(bb2!=null) { // num pass 일치
			boardService.deleteBoard(bb); // 삭제
			return "redirect:/board/list";
		} else { // 불일치
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다");
			return "/board/msg";
		}
		
	}
	
	//============================= 파일 ==========================================
	
	@RequestMapping(value = "/board/fwrite", method = RequestMethod.GET)
	public String fwrite() {
		
		return "/board/fwriteForm";
	}
	
	@RequestMapping(value = "/board/fwritePro", method = RequestMethod.POST)
	public String fwritePro(HttpServletRequest request, MultipartFile file) throws Exception {
		
		UUID uid = UUID.randomUUID();
		// 랜덤문자열_파일이름
		String saveName = uid.toString() + "_" + file.getOriginalFilename();
//		System.out.println(saveName);
		
		// upload 폴더로 복사
		File target = new File(uploadPath, saveName);
		FileCopyUtils.copy(file.getBytes(), target); 
		
		BoardBean bb = new BoardBean();
		bb.setContent(request.getParameter("content"));
		bb.setName(request.getParameter("name"));
		bb.setPass(request.getParameter("pass"));
		bb.setSubject(request.getParameter("subject"));
		bb.setFile(saveName);
		
		boardService.finsertBoard(bb);
		
		return "redirect:/board/flist";
	}
	
	@RequestMapping(value = "/board/flist", method = RequestMethod.GET)
	public String flist(Model model, HttpServletRequest request) {
		
		PageBean pb = new PageBean();
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) { pageNum = "1"; }
		pb.setPageNum(pageNum);
		
		int pageSize = 10;
		pb.setPageSize(pageSize);
		
		List<BoardBean> bbList = boardService.fgetBoardList(pb);
		
		pb.setCount(boardService.fgetBoardCount());
		
		model.addAttribute("bbList", bbList);
		model.addAttribute("pb", pb);
		
		return "/board/flist";
	}
	
	@RequestMapping(value = "/board/fcontent", method = RequestMethod.GET)
	public String fcontent(Model model,HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		BoardBean bb = boardService.fgetBoard(num);
		model.addAttribute("bb",bb);
		return "/board/fcontent";
	}

	//--------------------------------------------------------------------------
	
	@RequestMapping(value = "/board/alist", method = RequestMethod.GET)
	public String alist() {
		
		return "/board/ajaxlist";
	}
}
