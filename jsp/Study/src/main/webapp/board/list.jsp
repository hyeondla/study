<%@page import="board.BoardBean"%>
<%@page import="java.util.List"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// BoardDAO bdao 객체생성
BoardDAO bdao=new BoardDAO();
// 게시판 글을 10개 잘라서 1페이지 가져오기
// 한화면에 보여줄 글개수 설정 
int pageSize=10;
// http://localhost:8080/Study/board/list.jsp
// http://localhost:8080/Study/board/list.jsp?pageNum=3
// 페이지 가져오기
// 페이지가 없으면 "1"로 설정
String pageNum=request.getParameter("pageNum");
if(pageNum==null){
	pageNum="1";
}
// 시작하는 행번호를 구하기 (pageSize pageNum 조합해서 구하기)
int currentPage=Integer.parseInt(pageNum);
// 페이지번호currentPage 한화면에보여줄 글수 pageSize=>startRow
//    1        10     => (1-1)*10+1=>0*10+1=>0+1 =>1
//    2        10     => (2-1)*10+1=>1*10+1=>10+1=>11
//    3        10     => (3-1)*10+1=>2*10+1=>20+1=>21
int startRow=(currentPage-1)*pageSize+1;
// 끝나는 행번호를 구하기 
// startRow pageSize => endRow 
//    1        10      => 10
//    11       10      => 20
//    21       10      => 30
int endRow=startRow+pageSize-1;


// 메서드 정의 리턴할형 List  getBoardList()
// List = getBoardList() 메서드 호출
// select * from board order by num desc
// List boardList =bdao.getBoardList();

// select * from board order by num desc limit 시작하는행-1,한화면에 보여줄 글개수
List boardList=bdao.getBoardList(startRow,pageSize);

%>
<h1>board/list.jsp</h1>
<table border="1">
<tr><td>글번호</td><td>글제목</td><td>글쓴이</td>
    <td>글쓴날짜</td><td>조회수</td></tr>
    <%
    for(int i=0;i<boardList.size();i++){
    	BoardBean bb =(BoardBean) boardList.get(i);
    	%><tr><td><%=bb.getNum() %></td>
    	      <td><a href="content.jsp?num=<%=bb.getNum()%>">
    	      <%=bb.getSubject() %></a></td>
    	      <td><%=bb.getName() %></td>
              <td><%=bb.getDate() %></td>
              <td><%=bb.getReadcount() %></td></tr><%
    }
    %>
</table>
<%
// 한화면에 보여지는 페이지 수 설정
int pageBlock=10;
//한화면에 보여지는 시작페이지 번호 구하기
// currentPage   pageBlock => startPage
//  1~10(00~09)     10     =>     (00~09)/10*10+1=>0*10+1=>0+1=>1
//  11~20(10~19)    10     =>     (10~19)/10*10+1=>1*10+1=>10+1=>11
//  21~30(20~29)    10     =>     (20~29)/10*10+1=>2*10+1=>20+1=>21
int startPage=(currentPage-1)/pageBlock*pageBlock+1;

// 한화면에 보여지는 끝페이지 번호 구하기
// startPage  pageBlock => endPage
//     1         10     =>   10
//     11        10     =>   20
int endPage=startPage+pageBlock-1;

// 전체 글개수 구하기 select count(*) from board;
int count=bdao.getCount();

// 실제페이지 구하기 
// 전체글개수 50 한화면에 보여줄 글수 10 => 페이지수 5+0 => 5
// 전체글개수 57 한화면에 보여줄 글수 10 => 페이지수 5+1 => 6
int pageCount=count/pageSize+(count%pageSize==0?0:1);

//구한 endPage 10  실제 페이지 2 => endPage 2로변경
if(endPage > pageCount){
	endPage=pageCount;
}

// <이전>
if(startPage > pageBlock){
	%><a href="list.jsp?pageNum=<%=startPage-pageBlock%>"><이전></a><%
}

for(int i=startPage;i<=endPage;i++){
	%><a href="list.jsp?pageNum=<%=i%>"><%=i %></a> <%
}

//<다음>
if(endPage < pageCount){
	%><a href="list.jsp?pageNum=<%=startPage+pageBlock%>"><다음></a><%
}
%>

</body>
</html>





