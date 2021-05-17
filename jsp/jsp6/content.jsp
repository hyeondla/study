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
int num = Integer.parseInt(request.getParameter("num"));

Class.forName("com.mysql.jdbc.Driver");

String dbUrl = "jdbc:mysql://localhost:3306/jspdb3";
String dbUser = "root"; 
String dbPass = "1234"; 
Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

String sql = "select * from board where num=?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setInt(1, num);

ResultSet rs = pstmt.executeQuery();

if(rs.next()){
	%>
	<table border="1">
	<tr><td>글번호</td><td><%=rs.getInt("num") %></td>
		<td>글쓴이</td><td><%=rs.getString("name") %></td></tr>
	<tr><td>작성날짜</td><td><%=rs.getString("date") %></td>
		<td>조회수</td><td><%=rs.getInt("readcount") %></td></tr>
	<tr><td>제목</td><td colspan="3"><%=rs.getString("subject") %></td></tr>
	<tr><td>내용</td><td colspan="3"><%=rs.getString("content") %></td></tr>
	<tr><td colspan="4"><input type="button" value="글목록" onClick="location.href='list.jsp'"></td></tr>
	</table>
	<%
}
%>
</body>
</html>