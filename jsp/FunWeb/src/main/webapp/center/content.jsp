<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
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
	<%
	int num = Integer.parseInt(request.getParameter("num"));
	BoardDAO bdao = new BoardDAO();
	BoardBean bb = bdao.getBoard(num);
	%>
	<article>
		<h1>Content</h1>
		<table id="notice">
			<tr><td>글번호</td><td><%=bb.getNum() %></td>
				<td>글쓴이</td><td><%=bb.getName() %></td></tr>
			<tr><td>작성날짜</td><td><%=bb.getDate() %></td>
				<td>조회수</td><td><%=bb.getReadcount() %></td></tr>
			<tr><td>제목</td><td colspan="3"><%=bb.getSubject() %></td></tr>
			<tr><td>내용</td><td colspan="3"><%=bb.getContent() %></td></tr>
		</table>
		<div id="table_search">
		<%
		String id = (String)session.getAttribute("id");
		if(id != null){
			if(id.equals(bb.getName())){
				%>
				<input type="button" value="글수정" onClick="location.href='update.jsp?num=<%=bb.getNum() %>'" class="btn">
				<input type="button" value="글삭제" onClick="location.href='delete.jsp?num=<%=bb.getNum() %>'" class="btn">
				<%
			}
		}%>
			<input type="button" value="글목록" onClick="location.href='notice.jsp'" class="btn">
		</div>
		<div class="clear"></div>
	</article>
	<div class="clear"></div>
<jsp:include page="../inc/bottom.jsp"/>
</div>
</body>
</html>