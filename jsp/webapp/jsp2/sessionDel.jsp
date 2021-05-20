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
//세션공간 값 하나 삭제
session.removeAttribute("session_name1");
%>
<script type="text/javascript">
	alert("세션 값 하나 삭제");
	location.href="sessionTest.jsp";
</script>
</body>
</html>