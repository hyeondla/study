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
<form action='<c:url value="/test4"/>'  method="get">
<input type="hidden" name="q1" value="${q1 }">
<input type="hidden" name="q2" value="${q2 }">
<input type="radio" name="q3" value="1"> 따뜻
<input type="radio" name="q3" value="2"> 포근
<input type="radio" name="q3" value="3"> 달달
<input type="radio" name="q3" value="4"> 상큼
<input type="radio" name="q3" value="5"> 머스크
<input type="submit" value="선택">
</form>

</body>
</html>