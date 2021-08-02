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
	<c:if test="${(empty sessionScope.id) }">
		<c:redirect url="/member/login" />
	</c:if>
	<article>
		<h1>File Update</h1>
		<form action='<c:url value="/fboard/fupdatePro"/>' method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${bb.num }">
		<table id="notice">
			<tr><td class="twrite">글쓴이</td><td><input type="text" name="name" value="${bb.name }" readonly></td></tr>
			<tr><td class="twrite">제목</td><td><input type="text" name="subject" value="${bb.subject }"></td></tr>
			<tr><td class="twrite">파일</td><td><input type="file" name="file">${bb.file }
												<input type="hidden" name="oldfile" value="${bb.file }"></td></tr>
			<tr><td class="twrite">내용</td><td><textarea rows="10" cols="20" name="content">${bb.content }</textarea></td></tr>
		</table>
		<div id="table_search">
			<input type="submit" value="글수정" class="btn">
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