package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDeleteProService;
import vo.ActionForward;

public class BoardDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		String board_pass = request.getParameter("board_pass");
		
		BoardDeleteProService boardDeleteProService = new BoardDeleteProService();
		boolean isRightUser = boardDeleteProService.isArticleWriter(board_num, board_pass);
		
		if(!isRightUser) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('삭제 권한이 없습니다');");
			out.print("history.back();");
			out.print("</script>");
		} else {
			boolean isDeleteSuccess = boardDeleteProService.removeArticle(board_num);
			if(!isDeleteSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('글 삭제 실패');");
				out.print("history.back();");
				out.print("</script>");
			} else {
				forward = new ActionForward();
				forward.setPath("BoardList.bo?page=" + page);
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}
