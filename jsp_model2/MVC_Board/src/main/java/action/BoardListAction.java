package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.PageInfo;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardListAction");
		
		ActionForward forward = null;
		
		// 페이징 처리
		int page = 1;
		int limit = 10;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardListService boardListService = new BoardListService();
		int listCount = boardListService.getListCount();
		
		ArrayList<BoardBean> articleList = boardListService.getArticleList(page, limit);
		
		// 페이징 계산
		int maxPage = (int)((double)listCount / limit + 0.9); // 전체 페이지 수
		int pageLimit = 10; 
		int startPage = ((int)((double)page / pageLimit + 0.9) - 1) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(page, listCount, maxPage, startPage, endPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
			
		
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./board/qna_board_list.jsp");
		
		
		return forward;
	}

}
