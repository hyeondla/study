> Model 2

디자인과 개발(비즈니스 로직)을 분리해서 작업

유지보수가 용이

<br>

> MVC 패턴

- Model : 데이터 베이스와 연동 등 비즈니스 로직 수행
- View : 화면 출력 (디자인 부분)
- Controller : 모델과 뷰를 연결, 초기 진입점

<img src="./img/model2_001.JPG"><br>

<br>

> Controller (서블릿)

초기 진입점, 뷰와 모델을 연동 → 서블릿으로 구성됨

뷰에서 컨트롤러 호출 → 비즈니스 로직 처리 요청

모델에서 컨트롤러 호출 → 처리 결과 전달

<br>

> View (JSP)

화면 출력, 디자인 요소 → JSP 페이지로 구성됨

<br>

> Model (POJO)

일반적인 클래스 파일 → 외부에서 직접적인 접근 불가

비즈니스 로직 수행, 데이터베이스 작업

<br>

---

<br>

> MVC 모델2 패턴을 사용한 게시판

브라우저 요청 → FrontController → View 포워딩 / Action 클래스 호출

1. Action 클래스 호출 → DAO 호출 → 비즈니스 로직 수행 → Controller에 결과 전달 → View로 결과 전달 → View에서 결과 출력

2. View 요청 → FrontController → Action 클래스 호출 → 비즈니스 로직 수행 → ...

<img src="./img/model2_002.JPG"><br>

> package db

DB 관련 공통 기능

```java
import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
    
	// Connection Pool에서 Connection 객체를 얻어와서 반환
	public static Connection getConnection(){
		Connection con=null;
        
		try {
			Context initCtx = new InitialContext(); 
			Context envCtx = (Context)initCtx.lookup("java:comp/env"); 
			DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQLDB"); 
			con = ds.getConnection();
			con.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		return con;
	}
    
	// 자원 반환
	public static void close(Connection con){
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt){
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs){
		
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    
	// 트랜잭션 작업 완료
	public static void commit(Connection con){
		try {
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
    
	// 트랜잭션 작업 취소
	public static void rollback(Connection con){
		try {
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
```

<br>

> package action

Action 인터페이스

→ 각 요청을 처리하는 Action 클래스들이 공통적으로 구현해야하는 execute 메서드 정의

```java
import javax.servlet.http.HttpServletRequest; // 웹 요청 처리
import javax.servlet.http.HttpServletResponse; // 웹 요청 응답
import vo.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
```

Action 클래스

→ FrontController에서 전송된 요청 파악 → execute 메서드 호출 → 각 요청 처리

→ 글 등록 요청, 글 목록 보기 요청, 글 내용 보기 요청, 글 수정폼 보기 요청, 글 수정 요청, 글 삭제 요청, 답변글 쓰기 폼 보기 요청, 답변글 등록 요청 등

```java
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardWriteProService;
import vo.ActionForward;
import vo.BoardBean;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteProAction implements Action { // 인터페이스 구현

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		ActionForward forward=null;
		BoardBean boardBean = null; // DTO 객체 생성
		String realFolder="";
		String saveFolder="/boardUpload";
		int fileSize=5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(saveFolder);   		
        
        // MultipartRequest 객체 생성
		MultipartRequest multi=new MultipartRequest(request,realFolder,fileSize,"UTF-8",new DefaultFileRenamePolicy());
		// DTO 객체에 정보 저장
        boardBean = new BoardBean();
		boardBean.setBOARD_NAME(multi.getParameter("BOARD_NAME"));
		boardBean.setBOARD_PASS(multi.getParameter("BOARD_PASS"));
		boardBean.setBOARD_SUBJECT(multi.getParameter("BOARD_SUBJECT"));
		boardBean.setBOARD_CONTENT(multi.getParameter("BOARD_CONTENT"));
		boardBean.setBOARD_FILE(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
        // 비즈니스 로직이 실행되는 메서드 호출
        BoardWriteProService boardWriteProService = new BoardWriteProService();
		boolean isWriteSuccess = boardWriteProService.registArticle(boardBean);

		if(!isWriteSuccess){ // 작업 실패
            // 자바 스크립트문
			response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('내용')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{ // 작업 성공
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo");
		}

		return forward;
		
	}  	
	
}
```

<br>

> package vo

ActionForward 클래스

→ 포워딩 정보 ①이동할 뷰 페이지 url ②포워딩 방식(디스패치/리다이렉트) 저장

```java
public class ActionForward {
	private boolean isRedirect=false; // 포워딩 방식
	private String path=null; // 포워딩 주소
	
	public boolean isRedirect(){
		return isRedirect;
	}
	
	public String getPath(){
		return path;
	}
	
	public void setRedirect(boolean b){
		isRedirect=b;
	}
	
	public void setPath(String string){
		path=string;
	}
}
```

BoardBean 클래스

→ 하나의 데이터로 다루어질 (게시판 글 하나) 정보 저장

```java
public class BoardBean {
	
    // private 변수 선언
    
    // getter
    
    // setter
    
}
```

PageInfo 클래스

→ 페이징 처리 관련 정보 저장

```java
public class PageInfo {
	
	private int page;
	private int maxPage;
	private int startPage;
	private int endPage;
	private int listCount;
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getMaxPage() {
		return maxPage;
	}
	
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public int getListCount() {
		return listCount;
	}
	
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

}
```

<br>

> package controller

컨트롤러 클래스

→ 모든 클라이언트(웹) 요청을 받아서 제어

```java
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import action.BoardDeleteProAction;
import action.BoardDetailAction;
import action.BoardListAction;
import action.BoardModifyFormAction;
import action.BoardModifyProAction;
import action.BoardReplyFormAction;
import action.BoardReplyProAction;
import action.BoardWriteProAction;
import vo.ActionForward;

@WebServlet("*.bo") // url이 *.bo인 요청을 매핑하는 서블릿으로 지정
public class BoardFrontController extends javax.servlet.http.HttpServlet 
{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // POST 방식 한글 처리
		// 전송된 요청 파악
        String command=request.getServletPath();
		ActionForward forward=null; // Action 클래스 객체의 execute 메서드 실행 후 반환되는 ActionForward 객체 저장
		Action action=null; // Action 클래스 객체 변수
		
        // 각 요청에 해당하는 Action 클래스 객체 실행 → ActionForward 객체 반환
		if(command.equals("/boardWriteForm.bo")){
			forward=new ActionForward();
			forward.setPath("/board/qna_board_write.jsp");
            // 페이지를 열어주는 요청 → 비즈니스 로직 실행 X, 포워딩 페이지만 지정
		}
        else if(command.equals("/boardWritePro.bo")){
			action  = new BoardWriteProAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardList.bo")){
			action = new BoardListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardDetail.bo")){
			action = new BoardDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardReplyForm.bo")){
			action = new BoardReplyFormAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardReplyPro.bo")){
			action = new BoardReplyProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardModifyForm.bo")){
			action = new BoardModifyFormAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/boardModifyPro.bo")){
			action = new BoardModifyProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/boardDeleteForm.bo")){
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);
			int board_num=Integer.parseInt(request.getParameter("board_num"));
			request.setAttribute("board_num",board_num);
			forward=new ActionForward();
			forward.setPath("/board/qna_board_delete.jsp");
		}
		else if(command.equals("/boardDeletePro.bo")){
			action = new BoardDeleteProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
        // 각 Action 클래스 객체에서 반환된 ActionForward 객체 정보 사용 → 포워딩 처리
		if(forward != null){
			if(forward.isRedirect()){ // 리다이렉트 
				response.sendRedirect(forward.getPath());
			}else{ // 디스패치
				RequestDispatcher dispatcher=
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}	
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}   
	
}
```

<br>

> package svc

Service 클래스

→ 각 클라이언트의 요청을 처리하는 비즈니스 로직이 구현됨

→ 글 등록 요청 처리 구현, 글 목록 보기 요청 처리 구현, 글 내용 보기 요청 처리 구현, 글 수정 요청 처리 구현, 글 삭제 요청 처리 구현, 답변글 등록 요청 처리 구현 등 (폼 보기 제외)

```java
import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

public class BoardWriteProService {

	public boolean registArticle(BoardBean boardBean) throws Exception{
		
		boolean isWriteSuccess = false; // 작업 성공 여부 저장
		Connection con = getConnection(); 
		BoardDAO boardDAO = BoardDAO.getInstance(); // DAO 클래스 인스턴스 얻어오기 (싱글톤)
		boardDAO.setConnection(con); // DAO 클래스에서 DB 작업 수행 시 사용할 Connection 객체
		int insertCount = boardDAO.insertArticle(boardBean); // DAO 메서드 호출
		
		if(insertCount > 0){ // 작업 성공 → commit
			commit(con);
			isWriteSuccess = true;
		} // 작업 실패 → rollback
		else{
			rollback(con);
		}
		
		close(con); // 자원 반환
		return isWriteSuccess; // 작업 성공 여부 반환
		
	}

}
```

<br>

> package dao

DB로 SQL 구문 전송

```java
import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.BoardBean;

public class BoardDAO { // 싱글톤 패턴 사용

	DataSource ds;
	Connection con;
	private static BoardDAO boardDAO; // private → 외부클래스에서 직접 접근 불가능

	private BoardDAO() {} // private → 외부클래스에서 새로운 객체 생성 불가능
    
    // 객체 생성, 리턴
	public static BoardDAO getInstance(){
		if(boardDAO == null){
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}
	
    // Connection 객체
	public void setConnection(Connection con){
		this.con = con;
	}

	// 전체 글 개수 반환
	public int selectListCount() {
		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt=con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
			if(rs.next()){
				listCount=rs.getInt(1);
			}
		}catch(Exception ex){
			System.out.println("getListCount 에러 : " + ex);			
		}finally{
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	// 글 목록 보기 
	public ArrayList<BoardBean> selectArticleList(int page,int limit){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql="select * from board order by BOARD_RE_REF desc,BOARD_RE_SEQ asc limit ?,10";
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		BoardBean board = null;
		int startrow=(page-1)*10; 
		try{
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			while(rs.next()){
				board = new BoardBean();
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				articleList.add(board);
			}
		}catch(Exception ex){
			System.out.println("getBoardList 에러 : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}
		return articleList;
	}

	// 글 내용 보기
	public BoardBean selectArticle(int board_num){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean boardBean = null;
		try{
			pstmt = con.prepareStatement("select * from board where BOARD_NUM = ?");
			pstmt.setInt(1, board_num);
			rs= pstmt.executeQuery();
			if(rs.next()){
				boardBean = new BoardBean();
				boardBean.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				boardBean.setBOARD_NAME(rs.getString("BOARD_NAME"));
				boardBean.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				boardBean.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				boardBean.setBOARD_FILE(rs.getString("BOARD_FILE"));
				boardBean.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				boardBean.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				boardBean.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				boardBean.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				boardBean.setBOARD_DATE(rs.getDate("BOARD_DATE"));
			}
		}catch(Exception ex){
			System.out.println("getDetail 에러 : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}
		return boardBean;
	}

	// 글 등록
	public int insertArticle(BoardBean article){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num =0;
		String sql="";
		int insertCount=0;
		try{
			pstmt=con.prepareStatement("select max(board_num) from board");
			rs = pstmt.executeQuery();
			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;
			sql="insert into board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
			sql+="BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF,"+
					"BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,"+
					"BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getBOARD_NAME());
			pstmt.setString(3, article.getBOARD_PASS());
			pstmt.setString(4, article.getBOARD_SUBJECT());
			pstmt.setString(5, article.getBOARD_CONTENT());
			pstmt.setString(6, article.getBOARD_FILE());
			pstmt.setInt(7, num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			insertCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("boardInsert 에러 : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}
		return insertCount;
	}

	// 글 답변
	public int insertReplyArticle(BoardBean article){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_max_sql="select max(board_num) from board";
		String sql="";
		int num=0;
		int insertCount=0;
		int re_ref=article.getBOARD_RE_REF();
		int re_lev=article.getBOARD_RE_LEV();
		int re_seq=article.getBOARD_RE_SEQ();
		try{
			pstmt=con.prepareStatement(board_max_sql);
			rs = pstmt.executeQuery();
			if(rs.next())num =rs.getInt(1)+1;
			else num=1;
			sql="update board set BOARD_RE_SEQ=BOARD_RE_SEQ+1 where BOARD_RE_REF=? ";
			sql+="and BOARD_RE_SEQ>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,re_ref);
			pstmt.setInt(2,re_seq);
			int updateCount=pstmt.executeUpdate();
			if(updateCount > 0){
				commit(con);
			}
			re_seq = re_seq + 1;
			re_lev = re_lev+1;
			sql="insert into board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
			sql+="BOARD_CONTENT, BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,";
			sql+="BOARD_READCOUNT,BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getBOARD_NAME());
			pstmt.setString(3, article.getBOARD_PASS());
			pstmt.setString(4, article.getBOARD_SUBJECT());
			pstmt.setString(5, article.getBOARD_CONTENT());
			pstmt.setString(6, ""); 
			pstmt.setInt(7, re_ref);
			pstmt.setInt(8, re_lev);
			pstmt.setInt(9, re_seq);
			pstmt.setInt(10, 0);
			insertCount = pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("boardReply 에러 : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}
		return insertCount;
	}

	// 글 수정
	public int updateArticle(BoardBean article){
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql="update board set BOARD_SUBJECT=?,BOARD_CONTENT=? where BOARD_NUM=?";
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getBOARD_SUBJECT());
			pstmt.setString(2, article.getBOARD_CONTENT());
			pstmt.setInt(3, article.getBOARD_NUM());
			updateCount = pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("boardModify 에러 : " + ex);
		}finally{
			close(pstmt);
		}
		return updateCount;
	}

	// 글 삭제
	public int deleteArticle(int board_num){
		PreparedStatement pstmt = null;
		String board_delete_sql="delete from board where BOARD_num=?";
		int deleteCount=0;
		try{
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setInt(1, board_num);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("boardDelete 에러 : "+ex);
		}	finally{
			close(pstmt);
		}
		return deleteCount;
	}

	// 조회수 업데이트
	public int updateReadCount(int board_num){
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql="update board set BOARD_READCOUNT = "+
				"BOARD_READCOUNT+1 where BOARD_NUM = "+board_num;
		try{
			pstmt=con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("setReadCountUpdate 에러 : "+ex);
		}
		finally{
			close(pstmt);
		}
		return updateCount;
	}

	// 글쓴이 확인
	public boolean isArticleBoardWriter(int board_num,String pass){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_sql="select * from board where BOARD_NUM=?";
		boolean isWriter = false;
		try{
			pstmt=con.prepareStatement(board_sql);
			pstmt.setInt(1, board_num);
			rs=pstmt.executeQuery();
			rs.next();
			if(pass.equals(rs.getString("BOARD_PASS"))){
				isWriter = true;
			}
		}catch(SQLException ex){
			System.out.println("isBoardWriter 에러 : "+ex);
		}
		finally{
			close(pstmt);
		}
		return isWriter;
	}

}
```

<br>

