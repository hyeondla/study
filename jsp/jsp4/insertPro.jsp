<%@page import="java.sql.Timestamp"%>
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
String id = request.getParameter("id");
String pass = request.getParameter("pass");
String name = request.getParameter("name");
Timestamp date = new Timestamp(System.currentTimeMillis()); //현시스템 날짜 시간

Class.forName("com.mysql.jdbc.Driver");

String dbUrl = "jdbc:mysql://localhost:3306/jspdb3";
String dbUser = "root";
String dbPass = "1234";
Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);

String sql = "insert into member(id,pass,name,date) values(?,?,?,?)";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, id);
pstmt.setString(2, pass);
pstmt.setString(3, name);
pstmt.setTimestamp(4, date);

pstmt.executeUpdate();

%>

회원가입 성공 : <%=pstmt %>
<script type="text/javascript">
	alert("회원가입 성공");
	location.href="loginForm.jsp";
</script>
</body>
</html>