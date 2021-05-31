<%@page import="member.MemberDAO"%>
<%@page import="member.MemberBean"%>
<%@page import="java.sql.Timestamp"%>
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
// String pass2 = request.getParameter("pass2");
String name = request.getParameter("name");
String email = request.getParameter("email");
// String email2 = request.getParameter("email2");
String address = request.getParameter("address");
String phone = request.getParameter("phone");
String mobile = request.getParameter("mobile");
Timestamp date = new Timestamp(System.currentTimeMillis());

MemberBean mb = new MemberBean();
mb.setId(id);
mb.setPass(pass);
mb.setName(name);
mb.setEmail(email);
mb.setAddress(address);
mb.setPhone(phone);
mb.setMobile(mobile);
mb.setDate(date);

MemberDAO mdao = new MemberDAO();
mdao.insertMember(mb);

%>
</body>
</html>