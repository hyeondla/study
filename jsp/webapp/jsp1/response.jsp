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
// response : 서버의 처리 결과를 저장하는 내장 객체
// response.setHeader("헤더이름","설정값")
// response.setHeader("accept-language","en")
// response.addCooki(쿠키값);
// response.setContentType("text/html; charset=UTF-8");
response.sendRedirect("request.jsp");
%>
</body>
</html>