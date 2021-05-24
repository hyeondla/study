<%@page import="board.BoardDAO"%>
<%@page import="board.BoardBean"%>
<%@page import="java.sql.Timestamp"%>
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
int readcount=0;
Timestamp date = new Timestamp(System.currentTimeMillis());

BoardBean bb = new BoardBean();
bb.setName(name);
bb.setPass(pass);
bb.setSubject(subject);
bb.setContent(content);
bb.setReadcount(readcount);
bb.setDate(date);

BoardDAO bdao = new BoardDAO();
bdao.insertBoard(bb);

response.sendRedirect("list.jsp");
%>
</body>
</html>