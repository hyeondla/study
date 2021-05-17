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
<form action="updatePro.jsp" method="post">
아이디 : <input type="text" name="id" value="<%=rs.getString("id") %>" readonly><br>
비밀번호 : <input type="password" name="pass"><br>
이름 : <input type="text" name="name" value="<%=rs.getString("name") %>"><br>
<!-- 나이, 성별, 이메일 추가 -->
나이 : <input type="text" name="age" value="<%=rs.getString("age") %>"><br>
성별 :
<input type="radio" name="gender" value="남" <% if(rs.getString("gender").equals("남")){ %> checked<%} %>>남
<input type="radio" name="gender" value="여" <% if(rs.getString("gender").equals("여")){ %> checked<%} %>>여<br> 
이메일 : <input type="text" name="email" value="<%=rs.getString("email") %>"><br>
<input type="submit" value="회원정보수정">
<input type="button" value="메인화면" onclick="location.href='main.jsp'"><br>
</form>
<%
}
%>
</body>
</html>