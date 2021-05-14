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
//세션값 가져오기
String id = (String)session.getAttribute("id");

//드라이버 로더
Class.forName("com.mysql.jdbc.Driver");

//DB 연결
String dbUrl = "jdbc:mysql://localhost:3306/jspdb3"; 
String dbUser = "root"; 
String dbPass = "1234"; 
Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

//SQL 구문
String sql = "select * from member where id=?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1,id);

//SQL(SELECT문) 실행 
ResultSet rs = pstmt.executeQuery();
//조건에 맞는 데이터가 있으면 접근
if(rs.next()){
%>
<form action="updatePro.jsp" method="post">
아이디 : <input type="text" name="id" value="<%=rs.getString("id") %>" readonly><br>
비밀번호 : <input type="password" name="pass"><br>
이름 : <input type="text" name="name" value="<%=rs.getString("name") %>"><br>
<input type="submit" value="회원정보수정">
</form>
<%
}
%>
</body>
</html>