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
Cookie cookie[] = request.getCookies();
if(cookie != null){
	for(int i=0; i<cookie.length; i++){
		if(cookie[i].getName().equals("cname")){
			cookie[i].setMaxAge(0);
			response.addCookie(cookie[i]);
		}
	}
}
%>

<script type="text/javascript">
	alert("쿠기값 하나 삭제");
	location.href = "cookieTest.jsp";
</script>

</body>
</html>