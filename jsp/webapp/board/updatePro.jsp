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

int num = Integer.parseInt(request.getParameter("num"));
String name = request.getParameter("name");
String pass = request.getParameter("pass");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

Class.forName("com.mysql.jdbc.Driver");

String dbUrl = "jdbc:mysql://localhost:3306/jspdb3";
String dbUser = "root"; 
String dbPass = "1234"; 
Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

String sql = "select * from board where num=? and pass=?";

PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setInt(1, num);
pstmt.setString(2, pass);

ResultSet rs = pstmt.executeQuery();

if(rs.next()){
	
	sql = "update board set subject=?, content=? where num=?";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, subject);
	pstmt.setString(2, content);
	pstmt.setInt(3, num);
	
	pstmt.executeUpdate();
	
	%>
	<script type="text/javascript">
		alert("수정되었습니다");
		location.href="list.jsp";
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