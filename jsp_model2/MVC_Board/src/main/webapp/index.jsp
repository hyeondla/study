<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String sessionId = (String)session.getAttribute("sessionId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h1 {
		text-align: center;
	}
	h3 {
		text-align: center;
	}
</style>
</head>
<body>
<div align="right">
	<% if(sessionId == null){ %>
	<h4><a href="MemberLoginForm.me">로그인</a> | <a href="MemberJoinForm.me">회원가입</a></h4>
	<% } else { %>
	<h4>
	   <%=sessionId %>님 | <a href="MemberLogout.me">로그아웃</a>
	   <% if(sessionId.equals("admin")) {%>
	   		| <a href="AdminMain.admin">관리자페이지</a>
	   <% } %>
	</h4>
	<% } %>
</div>
<h1>MVC 게시판</h1>
<h3><a href="BoardWriteForm.bo">글쓰기</a></h3>
<h3><a href="BoardList.bo">글목록</a></h3>
</body>
</html>