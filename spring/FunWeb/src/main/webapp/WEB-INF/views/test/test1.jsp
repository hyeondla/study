<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- https://paffem.me/perfume_teller.html?ptype=alpha4&a1i=2&a2i=1&a3i=3 -->
<form action='<c:url value="/test2"/>'  method="get">
<input type="radio" name="q1" value="1"> 여
<input type="radio" name="q1" value="2"> 남
<input type="radio" name="q1" value="3"> 성별무관
<input type="submit" value="선택">
</form>

</body>
</html>