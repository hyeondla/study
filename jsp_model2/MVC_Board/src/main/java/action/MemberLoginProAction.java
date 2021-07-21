package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberLoginProService;
import vo.ActionForward;
import vo.LoginFailException;

public class MemberLoginProAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      System.out.println("MemberLoginProAction");
      
      ActionForward forward = null;
      
      // 폼 파라미터로 전달받은 id, passwd 값 가져오기
      String id = request.getParameter("id");
      String password = request.getParameter("password");
      
//      System.out.println("아이디 : " + id + ", 패스워드 : " + password);
      
      // MemberLoginProService 클래스의 인스턴스 생성 후 login() 메서드 호출
      // => 파라미터 : 아이디, 패스워드     리턴타입 : boolean(isLoginSuccess)
      MemberLoginProService memberLoginProService = new MemberLoginProService();
      
      try {
         boolean isLoginSuccess = memberLoginProService.login(id, password);
         // => 주의! 현재 execute() 메서드에 throws Exception 이 적용되어 있으므로
         //    LoginFailException 도 위임 대상에 포함됨 => 직접 try/catch 적용
         
         if(isLoginSuccess) { // 로그인 성공 시
            // request 객체로부터 현재 세션 객체를 리턴받아
            // 로그인 성공한 아이디를 세션 객체의 속성값으로 저장하고
            // ActionForward 객체를 통해 index.jsp 페이지로 포워딩
            HttpSession session = request.getSession();
            session.setAttribute("sessionId", id);
            
            forward = new ActionForward();
            forward.setPath("./");
            forward.setRedirect(true);
            
         }
      } catch (LoginFailException e) {
//         e.printStackTrace();
    	  response.setContentType("text/html; charset=UTF-8"); // 문서 타입 지정
		  PrintWriter out = response.getWriter(); // PrintWriter 객체 가져오기
		  out.print("<script>");
		  out.print("alert('로그인 실패 - " + e.getMessage() + "');");
		  out.print("history.back()");
		  out.print("</script>");
      }
      
      
      return forward;
   }

}












