<%@page import="fboard.FileBoardBean"%>
<%@page import="fboard.FileBoardDAO"%>
<%@page import="java.util.List"%>
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
FileBoardDAO bdao = new FileBoardDAO();

int pageSize = 15; //한 화면에 보이는 글의 개수
String pageNum = request.getParameter("pageNum");
if(pageNum == null){
		pageNum = "1";
}
int currentPage = Integer.parseInt(pageNum);
//시작 행 번호 구하기
int startRow = (currentPage-1) * pageSize + 1;
//끝 행 번호 구하기
int endRow = startRow + pageSize - 1;
//select * from board order by num desc limit 시작행-1, 페이지사이즈
List<FileBoardBean> boardList = bdao.fgetBoardList(startRow, pageSize);
// List<BoardBean> boardList = bdao.getBoardList();

%>
<table border="1">
<tr><td>글번호</td><td>글제목</td><td>글쓴이</td><td>작성날짜</td><td>조회수</td></tr>
<%
for(int i=0; i<boardList.size(); i++){
	FileBoardBean bb = boardList.get(i);
	%>
	<tr>
		<td><%=bb.getNum() %></td>
		<td><a href="fcontent.jsp?num=<%=bb.getNum() %>"><%=bb.getSubject() %></a></td>
		<td><%=bb.getName() %></td>
		<td><%=bb.getDate() %></td>
		<td><%=bb.getReadcount() %></td>
	</tr>
	<%	
}
%>
</table>
<%
int pageBlock = 10; //한 화면에 보여지는 페이지 목록 개수 
int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
int endPage = startPage+pageBlock-1;
int count = bdao.fgetCount();
int pageCount = (count/pageSize)+(count%pageSize==0 ? 0:1);
if(endPage > pageCount){
	endPage = pageCount;
}

if(startPage > pageBlock){
	%><a href="flist.jsp?pageNum=<%=startPage-pageBlock %>">[이전]</a><%
}

for(int i=startPage; i<=endPage; i++){
	%><a href="flist.jsp?pageNum=<%=i %>"><%=i %></a> <%
}

if(endPage < pageCount){
	%><a href="flist.jsp?pageNum=<%=startPage+pageBlock %>">[다음]</a><%
}

%>
</body>
</html>