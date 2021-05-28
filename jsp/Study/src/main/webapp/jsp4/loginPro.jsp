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

Class.forName("com.mysql.jdbc.Driver");
String dbUrl = "jdbc:mysql://localhost:3306/jspdb3";
String dbUser = "root";
String dbPass = "1234";
Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);

// String sql = "select * from member where id=? and pass=?";
// PreparedStatement pstmt = con.prepareStatement(sql);
// pstmt.setString(1,id);
// pstmt.setString(2,pass);

String sql = "select * from member where id=?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1,id);

ResultSet rs = pstmt.executeQuery();

if(rs.next()){ //아이디 일치
	if(pass.equals(rs.getString("pass"))){
		//비밀번호 일치 => 세션값 생성
		session.setAttribute("id", id);
		response.sendRedirect("main.jsp");
	} else {
		%>	
		<script type="text/javascript">
		alert("비밀번호가 일치하지 않습니다");
		history.back();
		</script>
		<%
	}
} else {
%>	
<script type="text/javascript">
alert("가입되지 않은 아이디입니다");
history.back();
</script>
<%
}
%>


</body>
</html>