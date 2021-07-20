package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberLoginProService;
import vo.ActionForward;

public class MemberLoginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
//		System.out.println("id : " + id + ", password : " + password);
		
		MemberLoginProService memberLoginProService = new MemberLoginProService();
		boolean isLoginSuccess = memberLoginProService.login(id, password);
		if(!isLoginSuccess) {
			
		} else {
			
		}
		
		
		return forward;
	}


}
