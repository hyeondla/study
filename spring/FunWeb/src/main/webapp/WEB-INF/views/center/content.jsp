<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet" type="text/css">
<link href="<c:url value='/resources/css/subpage.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
<!-- 헤더 -->
<jsp:include page="../inc/top.jsp"/>

<!-- 본문 -->
	<!-- 메인 이미지 -->
	<div id="sub_img_center"></div>
	<!-- 왼쪽 메뉴 -->
	<nav id="sub_menu">
			<ul>
				<li><a href='<c:url value="/board/list"/>'>Notice</a></li>
				<li><a href="#">Public News</a></li>
				<li><a href='<c:url value="/fboard/flist"/>'>Driver Download</a></li>
				<li><a href="#">Service Policy</a></li>
				<li><a href='<c:url value="/center/mail"/>'>Q&amp;A</a></li>
			</ul>
	</nav>
	<!-- 본문 내용 -->
	<article>
		<h1>Notice Content</h1>
		<table id="notice">
			<tr><td>글번호</td><td>${bb.num }</td>
				<td>글쓴이</td><td>${bb.name }</td></tr>
			<tr><td>작성날짜</td><td>${bb.date }</td>
				<td>조회수</td><td>${bb.readcount }</td></tr>
			<tr><td>제목</td><td colspan="3">${bb.subject }</td></tr>
			<tr><td>내용</td><td colspan="3">${bb.content }</td></tr>
		</table>
		<div id="table_search">
			<c:if test="${!(empty sessionScope.id) }">
				<c:if test="${sessionScope.id eq bb.name }">
					<input type="button" value="글수정" onClick="location.href='<c:url value="/board/update?num=${bb.num }"/>'" class="btn">
					<input type="button" value="글삭제" onClick="location.href='<c:url value="/board/delete?num=${bb.num }"/>'" class="btn">
				</c:if>
			</c:if>
			<input type="button" value="글목록" onClick="location.href='<c:url value="/board/list"/>'" class="btn">
		</div>
		<div class="clear"></div>
	</article>
	<div class="clear"></div>
<jsp:include page="../inc/bottom.jsp"/>
</div>
</body>
</html>