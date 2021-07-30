package com.itwillbs.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.itwillbs.domain.BoardBean;
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
	
}
