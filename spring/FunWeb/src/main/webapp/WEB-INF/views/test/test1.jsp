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
<!-- 가상주소 뒤에 '?파라미터변수=값' 붙임 -->
<a href='<c:url value="/test2?q1=1"/>'><img src='<c:url value="/resources/perfume/10.jpg"/>' onmouseover="this.src='<c:url value="/resources/perfume/10_1.jpg"/>'" onmouseout="this.src='<c:url value="/resources/perfume/10.jpg"/>'"></a>
<a href='<c:url value="/test2?q1=2"/>'><img src='<c:url value="/resources/perfume/11.jpg"/>'></a>
<a href='<c:url value="/test2?q1=3"/>'><img src='<c:url value="/resources/perfume/12.JPG"/>'></a>

</body>
</html>