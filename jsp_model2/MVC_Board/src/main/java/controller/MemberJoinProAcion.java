package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.MemberJoinProService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberJoinProAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
//		String passwordConfirm = request.getParameter("passwordConfirm");
		String email = request.getParameter("email1") + "@" + request.getParameter("email2");
		
//		System.out.println(name + " " + id + " " + password + " " + email);
		
		MemberBean memberBean = new MemberBean();
		memberBean.setName(name);
		memberBean.setId(id);
		memberBean.setPassword(password);
		memberBean.setEmail(email);
		
		MemberJoinProService memberJoinProService = new MemberJoinProService();
		boolean isJoinSuccess = memberJoinProService.registMember(memberBean);
		
		if(!isJoinSuccess) {
			response.setContentType("text/html; charset=UTF-8"); // 문서 타입 지정
			PrintWriter out = response.getWriter(); // PrintWriter 객체 가져오기
			out.print("<script>");
			out.print("alert('회원가입 실패');");
			out.print("history.back()");
			out.print("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("./");
			forward.setRedirect(true);
		}
		
		
		return forward;
	}

}
