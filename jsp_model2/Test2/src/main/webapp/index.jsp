<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>index.jsp 입니다</h1>

<form action="GetPost.test" method="get">
<input type="submit" value="GET">
</form>

<form action="GetPost.test" method="post">
<input type="submit" value="POST">
</form>

<form action="MemberList.me" method="get">
<input type="text" name="id">
<input type="submit" value="me.GET">
</form>

<form action="MemberList.me" method="post">
<input type="submit" value="me.POST">
</form>

<%if(request.getParameter("id") != null){%>
	<input type="button" value="로그아웃" onclick="location.href='logout'">
<%} else {%>
<input type="button" value="로그인" onclick="location.href='loginForm.jsp'">
<%} %>

<hr>

<%if(request.getParameter("id") != null){%>
	<input type="button" value="로그아웃(통합)" onclick="location.href='logout.me2'">
<%} else {%>
<input type="button" value="로그인(통합)" onclick="location.href='loginForm.me2'">
<%} %>

</body>
</html>