<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function result() {
		opener.document.fr.id.value = document.wfr.id.value;
		window.close();
	}
</script>
</head>
<body>
<% 
String id = request.getParameter("id");
MemberDAO mdao = new MemberDAO();
MemberBean mb = mdao.getMember(id);
if(mb != null) {
	out.println("아이디 중복");
} else {
	out.println("아이디 사용가능");
	%>
	<input type="button" value="아이디사용" onclick="result()">
	<%
}
%>
<form action="winopen.jsp" method="post" name="wfr">
아이디 <input type="text" name="id" value="<%=id %>"><br>
<input type="submit" value="dup.check">
</form>
</body>
</html>