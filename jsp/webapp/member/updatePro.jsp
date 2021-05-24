<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
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

MemberDAO mdao = new MemberDAO();
MemberBean mb = mdao.userCheck(id, pass);

if(mb != null){
	
	MemberBean mb2 = new MemberBean();
	mb2.setId(id);
	mb2.setPass(pass);
	mb2.setName(name);
	mdao.updateMember(mb2);
	%>
	<script type="text/javascript">	
		alert("회원정보수정 완료");
		location.href="main.jsp";
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