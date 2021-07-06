<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>포워딩 방식 확인</h1>

<form action="DispatcherServlet" method="get">
<input type="text" name="id" value="admin">
<input type="submit" value="Dispatcher 이동">
</form>

<form action="RedirectServlet" method="get">
<input type="text" name="id" value="admin">
<input type="submit" value="Redirect 이동">
</form>

</body>
</html>