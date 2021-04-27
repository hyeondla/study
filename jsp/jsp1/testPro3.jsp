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
request.setCharacterEncoding("utf-8"); 
String name = request.getParameter("name"); 
String gender = request.getParameter("gender");
String[] hobby = request.getParameterValues("hobby");
String grade = request.getParameter("grade");
%>

이름 : <%=name %><br>
성별 : <%=gender %><br>
취미 개수 : <%=hobby.length %><br>
취미 : <%
	for(int i=0; i<hobby.length; i++){
	%>	<%=hobby[i] %> <%
	}
%><br>
학년 : <%=grade %><br>

</body>
</html>