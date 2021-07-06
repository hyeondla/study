

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("RedirectServlet");
		
		System.out.println("ID : " + request.getParameter("id"));
		
		request.setAttribute("data", "Redirect 방식 포워딩");
		
		response.sendRedirect("redirect.jsp");
		
	}

}
