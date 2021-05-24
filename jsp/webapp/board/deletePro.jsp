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
String pass = request.getParameter("pass");

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
	
	sql = "delete from board where num=?";
	pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, num);
	
	pstmt.executeUpdate();
	
	%>
	<script type="text/javascript">
		alert("삭제되었습니다")
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