package action;

import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardModifyProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("BoardModifyProAction");
		ActionForward forward = null;
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		BoardModifyProService boardModifyProService = new BoardModifyProService();
		
		String board_pass = request.getParameter("board_pass");
		boolean isRightUser = boardModifyProService.isArticleWrite(board_num, board_pass);
		
		if(!isRightUser) { // 비밀번호를 틀린 경우
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('수정 권한이 없습니다');");
			out.print("history.back();");
			out.print("</script>");
		} else { // 맞은 경우
//			System.out.println("패스워드 일치");
			BoardBean article = new BoardBean();
			article.setBoard_num(board_num);
			article.setBoard_name(request.getParameter("board_name"));
			article.setBoard_subject(request.getParameter("board_subject"));
			article.setBoard_content(request.getParameter("board_content"));
			
			boolean isModifySuccess = boardModifyProService.modifyArticle(article);
			
			if(!isModifySuccess) { // 글 수정 실패
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('글 수정 실패');");
				out.print("history.back();");
				out.print("</script>");
			} else { // 글 수정 성공
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("BoardDetail.bo?board_num=" + board_num + "&page=" + page);
			}
			
		}
		
		return forward;
	}

}
