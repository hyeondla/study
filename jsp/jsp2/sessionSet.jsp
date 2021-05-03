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
// 페이지 상관없이 값 유지
// 서버와 클라이언트 연결 정보를 저장하는 세션공간에 
// 이름:값 하나 저장 - 멤버함수(메서드)
session.setAttribute("session_name1", "session_value1");
session.setAttribute("session_name2", "session_value2");
%>
<script type="text/javascript">
	alert("세션 값 하나 생성");
	location.href="sessionTest.jsp";
</script>
</body>
</html>