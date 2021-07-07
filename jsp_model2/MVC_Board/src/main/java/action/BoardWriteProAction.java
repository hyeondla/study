package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.BoardWriteProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("BoardWriteProAction");
		
		ActionForward forward = null;
		
		String realFolder = ""; // 업로드파일 실제 저장 경로
		String saveFolder = "/boardUpload"; // 가상 경로
		int fileSize = 10 * 1024 * 1024; // 10MB
		
		ServletContext context = request.getServletContext();
		
		realFolder = context.getRealPath(saveFolder);
//		System.out.println("실제 업로드 폴더 : " + realFolder);
		
//		String writeIpAddr = request.getRemoteAddr();
//		System.out.println("작성자 IP 주소 : " + writeIpAddr);
		
		// 파일업로드 -> MultipartRequest 객체 생성
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize,"UTF-8", new DefaultFileRenamePolicy());
		
		// BoardBean 객체에 저장
		BoardBean bb = new BoardBean();
		bb.setBoard_name(multi.getParameter("board_name"));
		bb.setBoard_pass(multi.getParameter("board_pass"));
		bb.setBoard_subject(multi.getParameter("board_subject"));
		bb.setBoard_content(multi.getParameter("board_content"));
//		bb.setBoard_file(multi.getParameter("board_file"));
		bb.setBoard_file_original(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));
		bb.setBoard_file_real(multi.getFilesystemName((String) multi.getFileNames().nextElement()));
		
		// 실제 업로드 파일명
//		System.out.println("파일명 : " + multi.getOriginalFileName((String) multi.getFileNames().nextElement()));
		// 중복되는 파일에 의해 이름이 변경된 후의 파일명 가져오기
//		System.out.println("파일명 : " + multi.getFilesystemName((String) multi.getFileNames().nextElement()));
		
		// Service 클래스 인스턴스 생성
		BoardWriteProService boardWriteProService = new BoardWriteProService();
		boolean isWriteSuccess = boardWriteProService.registArticle(bb);
		
		if(!isWriteSuccess) { // 결과 false
			// 자바스크립트 메시지 출력
			response.setContentType("text/html; charset=UTF-8"); // 문서 타입 지정
			PrintWriter out = response.getWriter(); // PrintWriter 객체 가져오기
			out.print("<script>");
			out.print("alert('게시물 등록 실패');");
			out.print("history.back()");
			out.print("</script>");
			
		} else { // true
			forward = new ActionForward();
			forward.setPath("BoardList.bo");
			forward.setRedirect(true);
		}
		
		
		return forward;
	}

}
