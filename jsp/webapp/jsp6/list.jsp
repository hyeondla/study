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

String sql = "select * from board order by num desc"; 

PreparedStatement pstmt = con.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
%>
<table border="1">
<tr><td>글번호</td><td>글제목</td><td>글쓴이</td><td>작성날짜</td><td>조회수</td></tr>
<%
while(rs.next()){
	%>
	<tr>
		<td><%=rs.getInt("num") %></td>
		<td><a href="content.jsp?num=<%=rs.getInt("num") %>"><%=rs.getString("subject") %></a></td>
		<td><%=rs.getString("name") %></td>
		<td><%=rs.getString("date") %></td>
		<td><%=rs.getInt("readcount") %></td>
	</tr>
	<%	
}
%>

</table>
</body>
</html>