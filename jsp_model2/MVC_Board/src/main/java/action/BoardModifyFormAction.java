package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("BoardModifyFormAction");
		ActionForward forward = null;
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		System.out.println("글번호 : " + board_num);
		
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(board_num);
		
		if(article != null) {
			boardDetailService.increaseReadcount(board_num);
		}
		
		request.setAttribute("page", page);
		request.setAttribute("article", article);
		
		forward = new ActionForward();
		forward.setPath("./board/qna_board_modify.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	
}
