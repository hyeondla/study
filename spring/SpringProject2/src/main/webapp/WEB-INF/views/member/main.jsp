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
<c:if test="${ empty sessionScope }">
	<c:redirect url="login"></c:redirect>
</c:if>
${sessionScope.id }님
<input type="button" value="로그아웃" onclick="location.href='<c:url value="/member/logout" />'"><br>
<a href='<c:url value="/member/info" />'>회원정보조회</a><br>
<a href='<c:url value="/member/update" />'>회원정보수정</a><br>
<a href='<c:url value="/member/delete" />'>회원정보삭제</a><br>
<c:if test="${ ! empty sessionScope }">
	<c:if test="${ sessionScope.id eq 'admin' }">
		<a href='<c:url value="/member/list" />'>회원정보목록</a><br>
	</c:if>
</c:if>
</body>
</html>