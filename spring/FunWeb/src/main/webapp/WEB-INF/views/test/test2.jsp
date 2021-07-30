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
<form action='<c:url value="/test3"/>'  method="get">
<input type="hidden" name="q1" value="${q1 }">
<input type="radio" name="q2" value="1"> 봄
<input type="radio" name="q2" value="2"> 여름
<input type="radio" name="q2" value="3"> 가을
<input type="radio" name="q2" value="4"> 겨울
<input type="submit" value="선택">
</form>

</body>
</html>