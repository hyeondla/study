<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>board/updateForm.jsp</h1>
<%
int num=Integer.parseInt(request.getParameter("num"));
// BoardDAO bdao 객체생성
BoardDAO bdao=new BoardDAO();
// BoardBean bb = getBoard(num) 메서드 호출
BoardBean bb=bdao.getBoard(num);
	%>
<form action="updatePro.jsp" method="get">
<input type="hidden" name="num" value="<%=num%>">
<table border="1">
<tr><td>글쓴이</td>
    <td><input type="text" name="name" value="<%=bb.getName() %>" readonly></td></tr>
<tr><td>비밀번호</td>
    <td><input type="password" name="pass"></td></tr>
<tr><td>제목</td>
    <td><input type="text" name="subject" value="<%=bb.getSubject() %>"></td></tr>
<tr><td>내용</td>
    <td><textarea rows="10" cols="20" name="content"><%=bb.getContent() %></textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="글수정"></td></tr>    
</table>
</form>

</body>
</html>