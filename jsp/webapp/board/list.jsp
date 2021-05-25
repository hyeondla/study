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
List boardList = bdao.getBoardList();

%>
<table border="1">
<tr><td>글번호</td><td>글제목</td><td>글쓴이</td><td>작성날짜</td><td>조회수</td></tr>
<%
for(int i=0; i<boardList.size(); i++){
	BoardBean bb = (BoardBean)boardList.get(i); //형변환(다운캐스팅)
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
</body>
</html>