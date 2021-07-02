

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.me2")
public class Member extends HttpServlet { //=> 컨트롤러 역할
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();
		System.out.println(command);
		
		if(command.equals("/loginForm.me2")) {
			System.out.println("로그인 화면으로 이동");
			response.sendRedirect("loginForm2.jsp");
		} else if(command.equals("/loginPro.me2")) {
			String id = request.getParameter("id");
			String password = request.getParameter("password");
//			System.out.println("아이디 : " + id);
//			System.out.println("비밀번호 : " + password);
			MemberLoginPro pro = new MemberLoginPro();
			String path = pro.login(id, password);
//			response.sendRedirect("loginResult.jsp");
			response.sendRedirect(path);
		} else if(command.equals("/logout.me2")) {
			MemberLogoutPro pro = new MemberLogoutPro();
			String path = pro.logout();
			response.sendRedirect(path);
		} 
	}
}
