<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
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
String id = (String)session.getAttribute("id"); 

MemberDAO mdao = new MemberDAO();
MemberBean mb = mdao.getMember(id);
%> 

아이디 : <%=mb.getId() %><br>
비밀번호 : <%=mb.getPass() %><br>
이름 : <%=mb.getName() %><br>
가입날짜 : <%=mb.getDate() %><br>

<a href="main.jsp">main.jsp 이동</a>
</body>
</html>