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
<% 
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String pass = request.getParameter("pass");
String name = request.getParameter("name");
// 나이, 성별, 이메일 추가
String age = request.getParameter("age");
String gender = request.getParameter("gender");
String email = request.getParameter("email");
Timestamp date = new Timestamp(System.currentTimeMillis()); 

Class.forName("com.mysql.jdbc.Driver");

String dbUrl = "jdbc:mysql://localhost:3306/jspdb3";
String dbUser = "root";
String dbPass = "1234";
Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);

// 나이, 성별, 이메일 추가
String sql = "insert into member(id,pass,name,date,age,gender,email) values(?,?,?,?,?,?,?)";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, id);
pstmt.setString(2, pass);
pstmt.setString(3, name);
pstmt.setTimestamp(4, date);
pstmt.setString(5,age);
pstmt.setString(6, gender);
pstmt.setString(7, email);

pstmt.executeUpdate();

%>

<script type="text/javascript">
	alert("회원가입 성공");
	location.href="loginForm.jsp";
</script>

</body>
</html>