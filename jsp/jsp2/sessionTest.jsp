<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
세션값1 : <%=session.getAttribute("session_name1") %><br>
세션값2 : <%=session.getAttribute("session_name2") %><br>
<input type="button" value="세션공간 값 하나 저장" onclick="location.href='sessionSet.jsp'">
<input type="button" value="세션공간 값 하나 삭제" onclick="location.href='sessionDel.jsp'">
<input type="button" value="세션공간 전체 삭제 (로그아웃)" onclick="location.href='sessionInval.jsp'">

</body>
</html>