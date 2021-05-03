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
	session.invalidate();
%>
<script type="text/javascript">
	alert("세션공간 전체 삭제");
	location.href="sessionTest.jsp";
</script>
</body>
</html>