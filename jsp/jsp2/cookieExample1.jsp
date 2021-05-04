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
Cookie cookies[] = request.getCookies();

String language="";

if(cookies != null){
	for(int i=0; i<cookies.length; i++){
		if(cookies[i].getName().equals("clang")){
			out.println("들고온 쿠키값 : " + cookies[i].getValue() + "<br>");
			language = cookies[i].getValue();
		}
	}
}

if(language.equals("kor")){
	%> <h3>안녕하세요</h3> <%
} else if(language.equals("eng")) {
	%> <h3>Hello</h3> <%
}
%>
<form action="cookieExample2.jsp" method="get">
<input type="radio" name="lang" value="kor" <% if(language.equals("kor")){ %>checked<%}%>>한국어
<input type="radio" name="lang" value="eng"<% if(language.equals("eng")){ %>checked<%}%>>영어
<input type="submit" value="언어설정">
</form>
</body>
</html>