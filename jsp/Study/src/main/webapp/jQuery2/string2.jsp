<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
// String pass = request.getParameter("pass");

// 드라이버 로더
Class.forName("com.mysql.jdbc.Driver");
// 디비연결
String dbUrl="jdbc:mysql://localhost:3306/jspdb3";
String dbUser="root";
String dbPass="1234";
Connection con=DriverManager.getConnection(dbUrl,dbUser,dbPass);
// sql
String sql="select * from member where id=?";
PreparedStatement pstmt=con.prepareStatement(sql);
pstmt.setString(1, id);
// 실행 결과 저장
ResultSet rs=pstmt.executeQuery();
// 비교
if(rs.next()){
	%> 아이디 중복<%
}else {
	%> 아이디 사용가능<%
}
%>