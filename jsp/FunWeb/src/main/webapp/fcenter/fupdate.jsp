<%@page import="fboard.FileBoardBean"%>
<%@page import="fboard.FileBoardDAO"%>
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
				<li><a href="../center/notice.jsp">Notice</a></li>
				<li><a href="#">Public News</a></li>
				<li><a href="../fcenter/fnotice.jsp">Driver Download</a></li>
				<li><a href="#">Service Policy</a></li>
			</ul>
	</nav>
	<!-- 본문 내용 -->
	<%
	String id = (String)session.getAttribute("id");
	if(id == null) {
		response.sendRedirect("../member/login.jsp");
	}
	int num = Integer.parseInt(request.getParameter("num"));
	FileBoardDAO bdao = new FileBoardDAO();
	FileBoardBean bb = bdao.fgetBoard(num);
	%>
	<article>
		<h1>File Update</h1>
		<form action="fupdatePro.jsp" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="<%=num %>">
		<table id="notice">
			<tr><td class="twrite">글쓴이</td><td><input type="text" name="name" value="<%=id %>" readonly></td></tr>
			<tr><td class="twrite">제목</td><td><input type="text" name="subject" value="<%=bb.getSubject() %>"></td></tr>
			<tr><td class="twrite">파일</td><td><input type="file" name="file"><%=bb.getFile() %>
												<input type="hidden" name="oldfile" value="<%=bb.getFile() %>"></td></tr>
			<tr><td class="twrite">내용</td><td><textarea rows="10" cols="20" name="content"><%=bb.getContent() %></textarea></td></tr>
		</table>
		<div id="table_search">
			<input type="submit" value="글수정" class="btn">
			<input type="button" value="글목록" onClick="location.href='fnotice.jsp'" class="btn">
		</div>
		</form>
		<div class="clear"></div>
	</article>
	<div class="clear"></div>
<jsp:include page="../inc/bottom.jsp"/>
</div>
</body>
</html>