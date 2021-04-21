<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- request.멤버변수 -->
<!-- request.멤버함수() -->

<!-- request.getParameter("태그이름") : request에 저장된 값을 가져옴 -->

아이디 : <%=request.getParameter("id") %>
비밀번호 : <%=request.getParameter("pw") %>
자기소개 : <%=request.getParameter("intro") %>
성별 : <%=request.getParameter("gender") %>
취미 : <%=request.getParameter("hobby") %>
회원등급 : <%=request.getParameter("grade") %>


</body>
</html>