<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${ empty sessionScope }">
		<c:redirect url="login"></c:redirect>
	</c:when>
	<c:otherwise>
		<c:if test="${ sessionScope.id ne 'admin' }">
			<c:redirect url="main"></c:redirect>
		</c:if> 
	</c:otherwise>
</c:choose>
<table border="1">
	<tr><td>아이디</td><td>비밀번호</td><td>이름</td><td>가입날짜</td></tr>
	<c:forEach var="mb" items="${mbList }">
	<tr><td>${mb.id }</td><td>${mb.pass }</td><td>${mb.name }</td><td>${mb.date }</td></tr>
	</c:forEach>
</table>

<br>
<fmt:formatNumber value="50000" type="currency"/><br>
<fmt:formatNumber value="0.15" type="percent"/><br>
<fmt:formatNumber value="123456789" pattern="###,###,###"/><br>
<!-- 객체생성 액션태그 -->
<jsp:useBean id="date" class="java.util.Date"/><br>
<fmt:formatDate value="${date }" type="date"/><br>
<fmt:formatDate value="${date }" type="time"/><br>
<fmt:formatDate value="${date }" type="both"/><br>

</body>
</html>