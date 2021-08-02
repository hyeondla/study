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
두번째 선택 : ${sessionScope.q2 }<br>
세번째 선택 : ${sessionScope.q3 }<br>
</body>
</html>