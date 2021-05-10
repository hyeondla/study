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
int num = Integer.parseInt(request.getParameter("num"));
String name = request.getParameter("name");

Class.forName("com.mysql.jdbc.Driver");

String dbUrl = "jdbc:mysql://localhost:3306/jdbcdb3";
String dbUser = "root";
String dbPass = "1234";

Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

// String sql = "insert into student(num,name) values("+num+",'"+name+"')";
String sql = "insert into student(num,name) values(?,?)";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setInt(1, num);
pstmt.setString(2, name);

pstmt.executeUpdate();
%>

학생등록 성공 : <%=pstmt %>

</body>
</html>