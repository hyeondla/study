

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String command = request.getServletPath();
		
		if(command.equals("/BoardWriteForm.bo")) {
			System.out.println("글쓰기 폼");
		} else if(command.equals("/BoardWritePro.bo")) {
			System.out.println("글쓰기 액션");
		} else if(command.equals("/BoardList.bo")) {
			System.out.println("글목록");
		}
	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
