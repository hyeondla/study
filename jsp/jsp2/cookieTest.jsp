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
//사용자 컴퓨터에서 http(모든 쿠키값, 세션값, 태그값, 사용자정보, 서버정보) 가져오기
//=> 서버 request 내장객체에 저장
//쿠키 배열 변수에 저장
Cookie cookie[] = request.getCookies();
//쿠키값 있음
if(cookie != null){
	for(int i=0; i<cookie.length; i++){
		if(cookie[i].getName().equals("cname")){
			out.println("들고온 쿠키 주소값 : " + cookie[i] + "<br>");
			out.println("들고온 쿠키 이름 : " + cookie[i].getName() + "<br>");
			out.println("들고온 쿠키 값 : " + cookie[i].getValue() + "<br>");
		}
	}
}
%>
<input type="button" value="쿠키 값 하나 저장" onclick="location.href='cookieSet.jsp'">
<input type="button" value="쿠키 값 하나 삭제" onclick="location.href='cookieDel.jsp'">
</body>
</html>