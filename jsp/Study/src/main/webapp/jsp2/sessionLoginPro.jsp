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
// sessionLogin.jsp -> id,pw 입력 -> sessionLoginPro.jsp 요청 
// -> 웹서버에 id=값,pw=값 전달 -> 웹애플리케이션서버에 전달
// -> request, response 객체 생성 (기억장소 할당) -> request 요청정보 저장
// -> web.xml 참조, 서블릿 객체 생성
String id = request.getParameter("id");
String pw = request.getParameter("pw");
%>
입력한 아이디 : <%=id %><br>
입력한 비밀번호 : <%=pw %><br>

<%
//=> DB연동 가져왔다고 가정
String dbId = "admin";
String dbPw = "p123";
%>
DB 아이디 : <%=dbId %><br>
DB 비밀번호 : <%=dbPw %><br>

<%
if(id.equals(dbId)){ //기억장소 내용(문자열) 비교 => .equals()
	%>아이디 일치<br><%
	if(pw.equals(dbPw)){
		%>비밀번호 일치<br><%
		// 아이디, 비밀번호 일치 => 인증됨 
		//=> 권한 부여, 모든 페이지에서 권한 유지 => session 내장객체 사용
		session.setAttribute("id", id);
		response.sendRedirect("sessionMain.jsp");
	} else {
		%>비밀번호 불일치<br><%
	}
} else {
	%>아이디 불일치<%
}
%>

</body>
</html>