<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
String driver = "oracle.jdbc.OracleDriver";
String url = "jdbc:oracle:thin:@192.168.0.40:1521:orcl";
String user = "hr";
String password = "hr";

Class.forName(driver);
Connection con = DriverManager.getConnection(url, user, password);

String sql = "SELECT * FROM employees";
PreparedStatement pstmt = con.prepareStatement(sql);

ResultSet rs = pstmt.executeQuery();

%>

<table border="1">
	<tr>
          <th>EMPLOYEE_ID</th>
          <th>FIRST_NAME</th>
          <th>LAST_NAME</th>
          <th>EMAIL</th>
          <th>PHONE_NUMBER</th>
          <th>HIRE_DATE</th>
          <th>JOB_ID</th>
          <th>SALARY</th>
          <th>COMMISSION_PCT</th>
          <th>MANAGER_ID</th>
          <th>DEPARTMENT_ID</th>
	</tr>
	<%
	while(rs.next()) {
	%>
	<tr>
		<td><%=rs.getInt(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getString(4) %></td>
		<td><%=rs.getString(5) %></td>
		<td><%=rs.getDate(6) %></td>
		<td><%=rs.getString(7) %></td>
		<td><%=rs.getInt(8) %></td>
		<td><%=rs.getInt(9) %></td>
		<td><%=rs.getInt(10) %></td>
		<td><%=rs.getInt(11) %></td>
	</tr>
	<%
	}
	%>
</table>

<%
rs.close();
pstmt.close();
con.close();
%>
</body>
</html>