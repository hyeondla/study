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
첫번째 선택 : ${sessionScope.q1 }<br>
두번째 선택 <br>
<a href='<c:url value="/test3?q2=1"/>'><img src='<c:url value="/resources/perfume/13.JPG"/>'></a>
<a href='<c:url value="/test3?q2=2"/>'><img src='<c:url value="/resources/perfume/14.jpg"/>'></a>

</body>
</html>