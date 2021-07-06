

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("DispatcherServlet");
		
		System.out.println("ID : " + request.getParameter("id"));
		
		request.setAttribute("data", "Dispatcher 방식 포워딩");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("dispatcher.jsp");
		dispatcher.forward(request, response);
		
	}
	
}
