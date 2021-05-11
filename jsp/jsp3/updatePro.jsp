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
<% request.setCharacterEncoding("utf-8"); %>
<%
int num = Integer.parseInt(request.getParameter("num"));
String name = request.getParameter("name");

Class.forName("com.mysql.jdbc.Driver");

String dbUrl = "jdbc:mysql://localhost:3306/jspdb3"; 
String dbUser = "root"; 
String dbPass = "1234"; 
Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

String sql = "update student set name=? where num=?"; 
PreparedStatement pstmt = con.prepareStatement(sql);

pstmt.setString(1, name);
pstmt.setInt(2, num);

pstmt.executeUpdate();
%>

이름 변경 성공 : <%=pstmt %>

</body>
</html>