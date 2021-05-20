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

Class.forName("com.mysql.jdbc.Driver");

String dbUrl = "jdbc:mysql://localhost:3306/jspdb3"; 
String dbUser = "root"; 
String dbPass = "1234"; 
Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

String sql = "select * from member where id=?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1,id);

ResultSet rs = pstmt.executeQuery();

if(rs.next()){
	%> 
	아이디 : <%=rs.getString("id") %><br>
	비밀번호 : <%=rs.getString("pass") %><br>
	이름 : <%=rs.getString("name") %><br>
	가입날짜 : <%=rs.getTimestamp("date") %><br>	
	<!-- 	나이, 성별, 이메일 추가 -->
	나이 : <%=rs.getString("age") %><br>
	성별 : <%=rs.getString("gender") %><br>
	이메일 : <%=rs.getString("email") %><br>
	<%
}

%>
<input type="button" value="메인화면" onclick="location.href='main.jsp'"><br>
</body>
</html>