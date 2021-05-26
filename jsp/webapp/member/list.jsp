<%@page import="member.MemberBean"%>
<%@page import="java.util.List"%>
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
String id = (String)session.getAttribute("id");

if(id==null){
	response.sendRedirect("loginForm.jsp");
} else {
	if(!id.equals("admin")){
		response.sendRedirect("main.jsp");
	}
}

MemberDAO mdao = new MemberDAO();
// List memberList = mdao.getMemberList();
List<MemberBean> memberList = mdao.getMemberList();
//=> 제네릭 타입
%>
<table border="1">
	<tr><td>아이디</td><td>비밀번호</td><td>이름</td><td>가입날짜</td></tr>
<%
for(int i=0; i<memberList.size(); i++){
// 	MemberBean mb = (MemberBean)memberList.get(i); //다운캐스팅
	MemberBean mb = memberList.get(i);
	// 제네릭 타입 => 다운캐스팅 없이 사용 가능
%>
	<tr>
		<td><%=mb.getId() %></td>
		<td><%=mb.getPass() %></td>
		<td><%=mb.getName() %></td>
		<td><%=mb.getDate() %></td>
	</tr>		
<%
}
%>
</table>
</body>
</html>