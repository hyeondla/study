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
	<c:if test="${empty sessionScope.id }">
		<c:redirect url="/member/login"></c:redirect>
	</c:if>
	<article>
		<h1>Notice Deletes</h1>
		<form action='<c:url value="/fboard/fdeletePro"/>' method="post">
		<input type="hidden" name="num" value="${num }">
		<table id="notice">
		</table>
		<div id="table_search">
			<input type="submit" value="글삭제" class="btn">
			<input type="button" value="글목록" onClick="location.href='<c:url value="/fboard/flist"/>'" class="btn">
		</div>
		</form>
		<div class="clear"></div>
	</article>
	<div class="clear"></div>
<jsp:include page="../inc/bottom.jsp"/>
</div>
</body>
</html>