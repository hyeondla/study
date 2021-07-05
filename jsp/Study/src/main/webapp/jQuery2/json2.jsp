<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="member.MemberBean"%>
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
String sql="select * from member";
PreparedStatement pstmt=con.prepareStatement(sql);
//실행 결과 저장
ResultSet rs=pstmt.executeQuery();

// List mblist = new ArrayList();
// List => JSONArray
JSONArray mblist = new JSONArray();

while(rs.next()) {
// 	MemberBean mb = new MemberBean();
	// MemberBean => JSONObject
	JSONObject mb = new JSONObject();

// 	mb.setId(rs.getString("id"));
// 	mb.setPass(rs.getString("pass"));
// 	mb.setName(rs.getString("name"));
// 	mb.setDate(rs.getTimestamp("date"));
	mb.put("id", rs.getString("id"));
	mb.put("pass", rs.getString("pass"));
	mb.put("name", rs.getString("name"));
	mb.put("date", rs.getString("date"));
	
	mblist.add(mb);	
}
%>
<%-- <%=mblist %> --%>

