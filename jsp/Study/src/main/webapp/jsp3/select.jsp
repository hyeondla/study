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

Class.forName("com.mysql.jdbc.Driver");

String dbUrl = "jdbc:mysql://localhost:3306/jspdb3"; 
String dbUser = "root"; 
String dbPass = "1234"; 
Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

String sql = "select * from student"; 
PreparedStatement pstmt = con.prepareStatement(sql);

//ResultSet 내장객체 저장
ResultSet rs = pstmt.executeQuery();

// while(rs.next()){ //데이터 있으면 true
// 	out.println(rs.getInt(1));
// 	out.println(rs.getString(2)+"<br>");
// }
%>
<table border="1">
<tr><td>학생번호</td><td>학생이름</td></tr>
<%
while(rs.next()){
	%><tr><td><%=rs.getInt("num") %></td><td><%=rs.getString("name") %></td></tr><%	
}
%>
</table>
</body>
</html>