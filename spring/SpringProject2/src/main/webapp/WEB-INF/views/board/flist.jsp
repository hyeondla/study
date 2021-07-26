<%@page import="java.util.List"%>
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
<h1>board/list.jsp</h1>
<table border="1">
<tr>
<td>글번호</td><td>글제목</td><td>글쓴이</td>
<td>글쓴날짜</td><td>조회수</td>
</tr>
<c:forEach var="bb" items="${bbList }">
<tr>
<td><a href="<c:url value='/board/fcontent?num=${bb.num }'/>">${bb.num }</a></td>
<td>${bb.subject }</td><td>${bb.name }</td>
<td>${bb.date }</td><td>${bb.readcount }</td>
</tr>
</c:forEach>
</table>
<c:if test="${pb.startPage > pb.pageBlock }">
<a href="<c:url value='/board/list?pageNum=${pb.startPage - pb.pageBlock }'/>">이전</a>
</c:if>
<c:forEach var="i" begin="${pb.startPage }" end="${pb.endPage }" step="1">
	<a href="<c:url value='/board/list?pageNum=${i }'/>">${i }</a>
</c:forEach>
<c:if test="${pb.endPage < pb.pageCount }">
<a href="<c:url value='/board/list?pageNum=${pb.startPage + pb.pageBlock }'/>">다음</a>
</c:if>
</body>
</html>





