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
/*
	영역			영역객체			속성(저장데이터)유효범위
	--------------------------------------------------------------------------------------
	page			pageContext			현페이지 정보 저장
	request			request				클라이언트 요청처리되는 동안
	session			session				페이지 상관 없이 서버~클라이언트 연결되는 동안
	application		application			페이지 상관 없이 서버가 start되어 있는 동안
*/
%>

<form action="scopePro.jsp" method="get">
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="password" name="pw"><br>
<input type="submit" value="전송">
</form>

</body>
</html>