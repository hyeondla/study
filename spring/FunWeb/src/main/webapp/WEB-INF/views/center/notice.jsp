<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				<li><a href='<c:url value="/board/flist"/>'>Driver Download</a></li>
				<li><a href="#">Service Policy</a></li>
				<li><a href='<c:url value="/center/mail"/>'>Q&amp;A</a></li>
			</ul>
	</nav>
	<!-- 본문 내용 -->
	<article>
		<h1>Notice</h1>
		<table id="notice">
			<tr><th class="tno">No.</th>
			    <th class="ttitle">Title</th>
			    <th class="twriter">Writer</th>
			    <th class="tdate">Date</th>
			    <th class="tread">Read</th></tr>
			<c:forEach var="bb" items="${bbList }">
			<tr onclick="location.href='<c:url value="/board/content?num=${bb.num }"/>'"><td>${bb.num}</td>
				<td class="left">${bb.subject}</td>
				<td>${bb.name}</td>
				<td><fmt:formatDate value="${bb.date }" type="both" pattern="yyyy.MM.dd"/></td>
				<td>${bb.readcount}</td></tr>
			</c:forEach>
		</table>
		<div id="table_search">
			<form action='<c:url value="/board/listSearch"/>'method="post">
				<input type="text" name="search" class="input_box">
				<input type="submit" value="search" class="btn">
			</form>
		</div>
			<c:if test="${!(empty sessionScope.id) }">
				<div id="table_search">
					<input type="button" value="글쓰기" class="btn" onclick="location.href='<c:url value="/board/write"/>'">
				</div>
			</c:if>
		<div class="clear"></div>
		<div id="page_control">
			<c:if test="${pb.startPage > pb.pageBlock }">
				<a href='<c:url value="/board/list?pageNum=${pb.startPage-pb.pageBlock }"/>'>Prev</a>
			</c:if>
			<c:forEach var="i" begin="${pb.startPage }" end="${pb.endPage }" step="1">
				<a href='<c:url value="/board/list?pageNum=${i }"/>'>${i }</a>
			</c:forEach>
			<c:if test="${pb.startPage < pb.pageBlock }">
				<a href='<c:url value="/board/list?pageNum=${pb.startPage+pb.pageBlock }"/>'>Next</a>
			</c:if>
		</div>
	</article>
	<div class="clear"></div>
<jsp:include page="../inc/bottom.jsp"/>
</div>
</body>
</html>