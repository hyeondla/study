package com.itwillbs.myweb;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberBean;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.MemberServiceImpl;

@Controller
public class MemberController {
	
	// 멤버변수 정의
	private MemberService memberService;
	// 1) 생성자를 통해서 값 전달
//	public MemberController(MemberService memberService) {
//		// 기억장소 할당, 초기값 할당
//		this.memberService = memberService;
//	}
	// 2) set 메서드를 통해서 값 전달	
	@Inject
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
	//  /WEB-INF/views/insertForm.jsp 이동
		return "insertForm";
	}

	@RequestMapping(value = "/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberBean mb) {
		System.out.println("MemberController /insertPro");
		
		// ------- HttpServletRequest request 를 매개변수로 받았을 때 ------------
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("pass"));
//		System.out.println(request.getParameter("name"));
		
		// request 내장객체 파라미터값
		// => 자바빈 객체의 변수에 저장
		
//		MemberBean mb = new MemberBean();
//		mb.setId(request.getParameter("id"));
//		mb.setPass(request.getParameter("pass"));
//		mb.setName(request.getParameter("name"));
		// ------------------------------------------------------------------------		
		
		// ------- MemberBean mb 를 매개변수로 받았을 때 ------------
		// 폼의 파라미터 이름과 자바빈의 변수 이름이 일치하면 자동으로 저장됨
//		System.out.println(mb.getId());
//		System.out.println(mb.getPass());
//		System.out.println(mb.getName());
		// ----------------------------------------------------------
		
		// 회원가입 처리
		
		// 1) 자바 파일 하나로 객체 생성
//		MemberServiceImpl memberService = new MemberServiceImpl();
//		memberService.insertMember(mb);
		
		// 2) 부모인터페이스 추상메서드 => 상속받은 클래스 객체 생성
		//    부모 = 자식객체 (업캐스팅)
//		MemberService memberService = new MemberServiceImpl();
//		memberService.insertMember(mb);
		
		// 3) 스프링파일(xml)에서 자식클래스 객체 생성
		//    => root-context.xml
		memberService.insertMember(mb);
		
		
		
	//  /WEB-INF/views/loginForm.jsp 이동
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "loginForm";
	}
	
	@RequestMapping(value = "/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberBean mb, HttpSession session) {
		System.out.println("MemberController /loginPro");
//		System.out.println(mb.getId());
//		System.out.println(mb.getPass());
		
		// 로그인 처리
		MemberBean mb2 = memberService.userCheck(mb);
		if(mb != null) {
			// 세션값 생성
			session.setAttribute("id", mb.getId());
		}
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		return "main";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		MemberBean mb = memberService.getMember(id);
		model.addAttribute("mb", mb);
		
		return "info";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		MemberBean mb = memberService.getMember(id);
		model.addAttribute("mb", mb);
		
		return "updateForm";
	}
	
	@RequestMapping(value = "/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberBean mb) {
		System.out.println("MemberController /updatePro");
		// 업데이트 처리
		MemberBean mb2 = memberService.userCheck(mb); // 비밀번호 일치 체크
		if(mb2 != null) {
			memberService.updateMember(mb);
		}
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
		return "deleteForm";
	}
	
	@RequestMapping(value = "/deletePro", method = RequestMethod.POST)
	public String deletePro(MemberBean mb, HttpSession session) {
		System.out.println("MemberController /deletePro");
		// 삭제 처리
		MemberBean mb2 = memberService.userCheck(mb);
		if(mb2 != null) {
			memberService.deleteMember(mb);
			session.invalidate();
		}
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		
		List<MemberBean> mbList = memberService.getMemberList();
		model.addAttribute("mbList", mbList);
		
		return "list";
	}
	
}
