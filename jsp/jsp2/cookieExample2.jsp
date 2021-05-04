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
String lang = request.getParameter("lang"); 

Cookie cookie = new Cookie("clang",lang);
cookie.setMaxAge(3600);
response.addCookie(cookie);
%>

선택 언어 : <%=lang %><br>
<script type="text/javascript">
	alert("쿠키값으로 언어 설정");
	location.href="cookieExample1.jsp";
</script>

</body>
</html>