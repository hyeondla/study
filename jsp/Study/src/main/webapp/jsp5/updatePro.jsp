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
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String pass = request.getParameter("pass");
String name = request.getParameter("name");
// 나이, 성별, 이메일 추가
String age = request.getParameter("age");
String gender = request.getParameter("gender");
String email = request.getParameter("email");

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
	
// 	나이, 성별, 이메일 추가
	String sql2 = "update member set name=?, age=?, gender=?, email=? where id=?";
	PreparedStatement pstmt2 = con.prepareStatement(sql2);
	pstmt2.setString(1,name);
	pstmt2.setString(2,age);
	pstmt2.setString(3,gender);
	pstmt2.setString(4,email);
	pstmt2.setString(5,id);
	
	pstmt2.executeUpdate();
	%>
	<script type="text/javascript">	
		alert("회원정보수정 완료");
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