package com.itwillbs.controller;

import java.io.File;
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
import com.itwillbs.service.FBoardService;

@Controller
public class FBoardController {
	
	@Inject
	private FBoardService fBoardService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/fboard/fwrite", method = RequestMethod.GET)
	public String write() {
		return "/fcenter/fwrite";
	}
	@RequestMapping(value = "/fboard/fwritePro", method = RequestMethod.POST)
	public String writePro(HttpServletRequest request, MultipartFile file) throws Exception {
		
		UUID uid = UUID.randomUUID();
		String saveName = uid.toString() + "_" + file.getOriginalFilename();
		File target = new File(uploadPath, saveName);
		FileCopyUtils.copy(file.getBytes(), target);
		
		BoardBean bb = new BoardBean();
		bb.setName(request.getParameter("name"));
		bb.setPass(request.getParameter("pass"));
		bb.setSubject(request.getParameter("subject"));
		bb.setContent(request.getParameter("content"));
		bb.setFile(saveName);
		
		fBoardService.insertBoard(bb);
		return "redirect:/fcenter/flist";
	}
	
	@RequestMapping(value = "/fboard/flist", method = RequestMethod.GET)
	public String flist(HttpServletRequest request, Model model) {
		PageBean pb = new PageBean();
		if(request.getParameter("pageNum")==null) {
			pb.setPageNum("1");
		} else {
			pb.setPageNum(request.getParameter("pageNum"));
		}
		
		pb.setPageSize(15);
		List<BoardBean> bbList = fBoardService.getBoardList(pb);
		
		pb.setCount(fBoardService.getBoardCount());
		
		model.addAttribute("bbList", bbList);
		model.addAttribute("pb", pb);
		
		return "/fcenter/fnotice";
	}
	
	@RequestMapping(value = "/fboard/flistSearch", method = RequestMethod.POST)
	public String flistSearch(HttpServletRequest request, Model model) {
		PageBean pb = new PageBean();
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pb.setPageNum("1");
		} else {
			pb.setPageNum(pageNum);
		}
		int pageSize = 15;
		pb.setPageSize(pageSize);
		
		// ?????? 
		String search = request.getParameter("search");
		pb.setSearch(search);
		List<BoardBean> bbList = fBoardService.getBoardListSearch(pb);
		
		// ?????? ??? ??????
		pb.setCount(fBoardService.getBoardCountSearch(pb));
		
		model.addAttribute("bbList", bbList);
		model.addAttribute("pb", pb);
		
		return "/fcenter/fnoticeSearch";
	}
	
	@RequestMapping(value = "/fboard/fcontent", method = RequestMethod.GET)
	public String fcontent(HttpServletRequest request, Model model) {
		int num = Integer.parseInt(request.getParameter("num"));
		fBoardService.updateReadCount(num);
		BoardBean bb = fBoardService.getBoard(num);
		model.addAttribute("bb",bb);
		
		return "/fcenter/fcontent";
	}
	
	@RequestMapping(value = "/fboard/fupdate", method = RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		int num = Integer.parseInt(request.getParameter("num"));
		BoardBean bb = fBoardService.getBoard(num);
		model.addAttribute("bb",bb);
		return "/fcenter/fupdate";
	}
	@RequestMapping(value = "/fboard/fupdatePro", method = RequestMethod.POST)
	public String updatePro(HttpServletRequest request, MultipartFile file) throws Exception {
		BoardBean bb = new BoardBean();
		String saveName = "";
		bb.setNum(Integer.parseInt(request.getParameter("num")));
		System.out.println(request.getParameter("num"));
		if(!(file.isEmpty())) { // ????????? ?????? ??????
			UUID uid = UUID.randomUUID();
			saveName = uid.toString() + "_" + file.getOriginalFilename();
			File target = new File(uploadPath, saveName);
			FileCopyUtils.copy(file.getBytes(), target);
		} else {
			saveName = request.getParameter("oldfile");
		}
		bb.setName(request.getParameter("name"));
		bb.setPass(request.getParameter("pass"));
		bb.setSubject(request.getParameter("subject"));
		bb.setContent(request.getParameter("content"));
		bb.setFile(saveName);
		fBoardService.updateBoard(bb);
		return "redirect:/fboard/flist";
	}
	
	@RequestMapping(value = "/fboard/fdelete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model) {
		int num = Integer.parseInt(request.getParameter("num"));
		model.addAttribute("num",num);
		return "/fcenter/fdelete";
	}
	@RequestMapping(value = "/fboard/fdeletePro", method = RequestMethod.POST)
	public String deletePro(BoardBean bb) {
		fBoardService.deleteBoard(bb);
		return "redirect:/fboard/flist";
	}
	
}
