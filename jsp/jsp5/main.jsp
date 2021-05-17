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
String id = (String)session.getAttribute("id");

if(id==null){
	response.sendRedirect("loginForm.jsp");
} 
%>

<%=id %>님 로그인 하셨습니다<br>

<a href="info.jsp">회원정보조회</a><br>
<a href="updateForm.jsp">회원정보수정</a><br>
<a href="deleteForm.jsp">회원정보삭제</a><br>

<%
if(id!=null){
	if(id.equals("admin")){
		%>
		<a href="list.jsp">회원정보목록</a><br>
		<%
	}
}
%>

<input type="button" value="로그아웃" onclick="location.href='logout.jsp'"><br>

</body>
</html>