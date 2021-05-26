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

BoardDAO bdao = new BoardDAO();

//페이지 설정
int pageSize = 10;
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
List<BoardBean> boardList = bdao.getBoardList(startRow, pageSize);


// List<BoardBean> boardList = bdao.getBoardList();

%>
<table border="1">
<tr><td>글번호</td><td>글제목</td><td>글쓴이</td><td>작성날짜</td><td>조회수</td></tr>
<%
for(int i=0; i<boardList.size(); i++){
	BoardBean bb = boardList.get(i);
	%>
	<tr>
		<td><%=bb.getNum() %></td>
		<td><a href="content.jsp?num=<%=bb.getNum() %>"><%=bb.getSubject() %></a></td>
		<td><%=bb.getName() %></td>
		<td><%=bb.getDate() %></td>
		<td><%=bb.getReadcount() %></td>
	</tr>
	<%	
}
%>
</table>

<a href = "list.jsp?pageNum=1">1</a>
<a href = "list.jsp?pageNum=2">2</a>

</body>
</html>