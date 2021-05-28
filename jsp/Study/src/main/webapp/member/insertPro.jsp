<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
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
String name = request.getParameter("name");
Timestamp date = new Timestamp(System.currentTimeMillis()); 

//MemberDAO 기억장소 할당 => 객체 생성 mdao
MemberDAO mdao = new MemberDAO();

//MemberBean 기억장소 할당 => 객체 생성 mb
MemberBean mb = new MemberBean();
mb.setId(id);
mb.setPass(pass);
mb.setName(name);
mb.setDate(date);

//insertMember() 호출
mdao.insertMember(mb);

%>
<script type="text/javascript">
	alert("회원가입 성공");
	location.href="loginForm.jsp";
</script>
</body>
</html>