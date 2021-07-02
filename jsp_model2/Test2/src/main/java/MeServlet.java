

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MeServlet
 */
@WebServlet("*.me")
public class MeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("GET/POST");
		String requestURL = request.getRequestURL().toString();
		System.out.println("reqeustURL : " + requestURL);
		
		// "/프로젝트명/서블릿주소" 추출
		String requestURI = request.getRequestURI();
		System.out.println("reqeustURI : " + requestURI);
		
		// "/프로젝트명" 추출
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);
		
		// "requestURI - contextPath = 서블릿주소"
		String command = requestURI.substring(contextPath.length());
		System.out.println("command : " + command);
		
		//----------------------------------------------------------
		
		String command2 = request.getServletPath();
		System.out.println("command2 : " + command2);
		
		
	}

}
