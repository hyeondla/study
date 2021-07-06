package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("BoardFrontController");
		
		request.setCharacterEncoding("UTF-8");
		
		// 서블릿 주소 추출
		String command = request.getServletPath();
//		System.out.println("command : " + command);
		
		// 포워딩 정보 관리 객체 변수 선언
		ActionForward forward = null;
		
		// 서블릿 주소 매핑 -> 포워딩 설정
		if(command.equals("/BoardWriteForm.bo")) {
			forward = new ActionForward();
			forward.setPath("./board/qna_board_write.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/BoardWritePro.bo")) {
			
		}
		
		
		
		// 포워딩 작업
		if(forward != null) {
			
			if(forward.isRedirect()) { // Redirect
				response.sendRedirect(forward.getPath());
			} else { // Dispatcher
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
			
		}
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
