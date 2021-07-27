<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//드라이버 로더
Class.forName("com.mysql.jdbc.Driver");
//디비연결
String dbUrl="jdbc:mysql://localhost:3306/jspdb3";
String dbUser="root";
String dbPass="1234";
Connection con=DriverManager.getConnection(dbUrl,dbUser,dbPass);
//sql
String sql="select * from board order by num desc limit 0,5";
PreparedStatement pstmt=con.prepareStatement(sql);
//실행 결과 저장
ResultSet rs=pstmt.executeQuery();

JSONArray boardlist = new JSONArray();

while(rs.next()) {
	
	JSONObject bb = new JSONObject();
	
	bb.put("num", rs.getString("num"));
	bb.put("subject", rs.getString("subject"));
	bb.put("date", rs.getString("date"));
	
	boardlist.add(bb);
}
%>

<%=boardlist %>