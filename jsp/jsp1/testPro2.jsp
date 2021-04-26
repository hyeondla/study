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
//getParameter 전에 한글 처리 
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id"); 
int age = Integer.parseInt(request.getParameter("age"));
%>
아이디 : <%=id %> <br>
나이 : 
<%-- <% %> 안에 <%= %> 사용불가 --%>
<%
if(age >= 20){
	%><%=age %>세 성인입니다<%
} else {
	%><%=age %>세 미성년입니다<%
}
%>
</body>
</html>