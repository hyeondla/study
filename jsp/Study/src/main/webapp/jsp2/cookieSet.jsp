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
//쿠키 객체 생성
Cookie cookie = new Cookie("cname","cookie value");
//쿠키 시간 설정
cookie.setMaxAge(1800);
//쿠키 클라이언트에 저장
response.addCookie(cookie);
%>

쿠키 주소값 : <%=cookie %><br>
쿠키 이름 : <%=cookie.getName() %><br>
쿠키 값 : <%=cookie.getValue() %><br>

<script type="text/javascript">
	alert("쿠키값 하나 생성");
	location.href = "cookieTest.jsp";
</script>
</body>
</html>