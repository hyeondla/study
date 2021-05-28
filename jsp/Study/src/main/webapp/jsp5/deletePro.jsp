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
String id = request.getParameter("id");
String pass = request.getParameter("pass");

Class.forName("com.mysql.jdbc.Driver");

String dbUrl = "jdbc:mysql://localhost:3306/jspdb3"; 
String dbUser = "root"; 
String dbPass = "1234"; 
Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

String sql = "select * from member where id=? and pass=?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1,id);
pstmt.setString(2,pass);


ResultSet rs = pstmt.executeQuery();

if(rs.next()){
	
	sql = "delete from member where id=?";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,id);
	
	pstmt.executeUpdate();

	session.invalidate();
	%>
	<script type="text/javascript">	
		alert("탈퇴 완료");
		location.href="main.jsp";
	</script>
	<%
} else {
	%>
	<script type="text/javascript">
		alert("입력하신 정보가 틀립니다");
		history.back();
	</script>
	<%
}
%>
</body>
</html>