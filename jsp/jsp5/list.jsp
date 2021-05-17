<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
} else {
	if(!id.equals("admin")){
		response.sendRedirect("main.jsp");
	}
}

Class.forName("com.mysql.jdbc.Driver");
String dbUrl = "jdbc:mysql://localhost:3306/jspdb3"; 
String dbUser = "root"; 
String dbPass = "1234"; 
Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

String sql = "select * from member";
PreparedStatement pstmt = con.prepareStatement(sql);

ResultSet rs = pstmt.executeQuery();

%>
<!-- 나이, 성별, 이메일 추가 -->
<table border="1">
	<tr><td>아이디</td><td>비밀번호</td><td>이름</td><td>가입날짜</td><td>나이</td><td>성별</td><td>이메일</td></tr>
<%
while(rs.next()){
%>
<tr>
	<td><%=rs.getString("id") %></td>
	<td><%=rs.getString("pass") %></td>
	<td><%=rs.getString("name") %></td>
	<td><%=rs.getString("date") %></td>
	<td><%=rs.getString("age") %></td>
	<td><%=rs.getString("gender") %></td>
	<td><%=rs.getString("email") %></td>
</tr>		
<%
}
%>
</table>
<input type="button" value="메인화면" onclick="location.href='main.jsp'"><br>
</body>
</html>