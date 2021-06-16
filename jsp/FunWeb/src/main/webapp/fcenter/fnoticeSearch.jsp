<%@page import="fboard.FileBoardBean"%>
<%@page import="fboard.FileBoardDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
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
				<li><a href="../center/mail.jsp">Q&amp;A</a></li>
			</ul>
	</nav>
	<!-- 본문 내용 -->
	<% 
	request.setCharacterEncoding("utf-8");
	
	String search = request.getParameter("search");
	int pageSize = 15; // 한 화면에 보여줄 글 개수
	
	String pageNum = request.getParameter("pageNum"); // 페이지 번호
	if(pageNum == null) {
		pageNum = "1";
	}
	int currentPage = Integer.parseInt(pageNum); // 정수화
	
	int startRow = (currentPage-1) * pageSize + 1; // 시작 번호
	int endRow = startRow + pageSize - 1; // 끝 번호
	
	FileBoardDAO bdao = new FileBoardDAO();
	List<FileBoardBean> boardList = bdao.fgetBoardList(startRow, pageSize, search);
	
	%>
	<article>
		<h1>Notice Search</h1>
		<table id="notice">
			<tr><th class="tno">No.</th>
			    <th class="ttitle">Title</th>
			    <th class="twriter">Writer</th>
			    <th class="tdate">Date</th>
			    <th class="tread">Read</th></tr>
			<% 
			for(int i=0; i<boardList.size(); i++){
				FileBoardBean bb = boardList.get(i);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd"); // 날짜 포맷 
				%>
			<tr onclick="location.href='fcontent.jsp?num=<%=bb.getNum() %>'"><td><%=bb.getNum() %></td>
				<td class="left"><%=bb.getSubject() %></td>
				<td><%=bb.getName() %></td>
				<td><%=sdf.format(bb.getDate()) %></td>
				<td><%=bb.getReadcount() %></td></tr>
				<%
			}
			%>
		</table>
		<div id="table_search">
			<form action="fnoticeSearch.jsp" method="post">
				<input type="text" name="search" class="input_box">
				<input type="submit" value="search" class="btn">
			</form>
		</div>
		<%
		String id = (String)session.getAttribute("id");
		if(id != null){
			%>
			<div id="table_search">
				<input type="button" value="글쓰기" class="btn" onclick="location.href='fwrite.jsp'">
			</div>
			<%
		}
		%>
		<div class="clear"></div>
		<div id="page_control">
			<% 
		int pageBlock = 10; //페이지 수
		int startPage = (currentPage-1) / pageBlock * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		int count = bdao.fgetBoardCount(search);
		int pageCount = count / pageSize + (count%pageSize==0 ? 0 : 1);
		if(endPage > pageCount) {
			endPage = pageCount; 
		}
		if(startPage > pageBlock) {
			%><a href="fnoticeSearch.jsp?pageNum=<%=startPage-pageBlock %>&search=<%=search %>">Prev</a><%
		}
		for(int i=startPage; i<=endPage; i++) {
			%><a href="fnoticeSearch.jsp?pageNum=<%=i%>&search=<%=search %>"><%=i %></a><%
		}
		if(endPage < pageCount) {
			%><a href="fnoticeSearch.jsp?pageNum=<%=endPage+pageBlock %>&search=<%=search %>">Next</a><%
		}
		%>
		</div>
	</article>
	<div class="clear"></div>
<jsp:include page="../inc/bottom.jsp"/>
</div>
</body>
</html>