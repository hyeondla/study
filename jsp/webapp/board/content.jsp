<%@page import="board.BoardBean"%>
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
int num = Integer.parseInt(request.getParameter("num"));

BoardDAO bdao = new BoardDAO();
bdao.updateReadcount(num);
BoardBean bb = bdao.getBoard(num);

if(bb != null){
	%>
	<table border="1">
		<tr><td>글번호</td><td><%=bb.getNum() %></td>
			<td>글쓴이</td><td><%=bb.getName() %></td></tr>
		<tr><td>작성날짜</td><td><%=bb.getDate() %></td>
			<td>조회수</td><td><%=bb.getReadcount() %></td></tr>
		<tr><td>제목</td><td colspan="3"><%=bb.getSubject() %></td></tr>
		<tr><td>내용</td><td colspan="3"><%=bb.getContent() %></td></tr>
		<tr><td colspan="4">
				<input type="button" value="글수정" onClick="location.href='updateForm.jsp?num=<%=bb.getNum()%>'">
				<input type="button" value="글삭제" onClick="location.href='deleteForm.jsp?num=<%=bb.getNum()%>'">
				<input type="button" value="글목록" onClick="location.href='list.jsp'">
			</td></tr>
	</table>
	<%
}
%>
</body>
</html>