<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>scopeProPro.jsp</h1>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
%>

요청정보 아이디 : <%=id %><br>
요청정보 비밀번호 : <%=pw %><br>

pageContext 값 : <%=pageContext.getAttribute("page") %><br>
request 값 : <%=request.getAttribute("req") %><br>
session 값 : <%=session.getAttribute("ses") %><br>
application 값 : <%=application.getAttribute("app") %><br>

</body>
</html>