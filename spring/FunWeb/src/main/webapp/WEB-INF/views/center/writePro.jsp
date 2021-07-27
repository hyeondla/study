<%@page import="board.BoardDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="board.BoardBean"%>
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
request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
String pass = request.getParameter("pass");
String subject = request.getParameter("subject");
String content = request.getParameter("content");
Timestamp date = new Timestamp(System.currentTimeMillis());

BoardBean bb = new BoardBean();
bb.setName(name);
bb.setPass(pass);
bb.setSubject(subject);
bb.setContent(content);
bb.setDate(date);
bb.setReadcount(0);

BoardDAO bdao = new BoardDAO();
bdao.insertBoard(bb);
%>
<script type="text/javascript">
alert("글이 등록되었습니다");
location.href = "notice.jsp";
</script>
</body>
</html>