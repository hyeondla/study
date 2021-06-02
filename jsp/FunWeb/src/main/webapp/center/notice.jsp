<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
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
				<li><a href="#">Notice</a></li>
				<li><a href="#">Public News</a></li>
				<li><a href="#">Driver Download</a></li>
				<li><a href="#">Service Policy</a></li>
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
			<tr><td>글번호</td>
				<td class="left">제목</td>
				<td>작성자</td>
				<td>날짜</td>
				<td>조회수</td></tr>
		</table>
		<div id="table_search">
			<input type="text" name="search" class="input_box">
			<input type="button" value="search" class="btn">
		</div>
		<div class="clear"></div>
		<div id="page_control">
			<a href="#">Prev</a>
			<a href="#">1</a>
			<a href="#">2</a>
			<a href="#">Next</a>
		</div>
	</article>
	<div class="clear"></div>
<jsp:include page="../inc/bottom.jsp"/>
</div>
</body>
</html>