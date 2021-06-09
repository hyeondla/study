<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.BoardBean"%>
<%@page import="java.util.List"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/front.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
<!-- 헤더 -->
<jsp:include page="../inc/top.jsp"/>

<div class="clear"></div>
<!-- 본문 -->
	<!-- 메인 이미지 -->
	<div id="main_img"><img src="../images/main_img.jpg"></div>
	<!-- 본문 내용 -->
	<article id="front">
		<div id="solution">
			<div id="hosting">
				<h3>Web Hosting Soulution</h3>
				<p>Lorem impsun Lorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsun....</p>
			</div>
			<div id="security">
				<h3>Web Security Soulution</h3>
				<p>Lorem impsun Lorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsun....</p>
			</div>
			<div id="payment">
				<h3>Web Payment Soulution</h3>
				<p>Lorem impsun Lorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsun....</p>
			</div>
		</div>
		<div class="clear"></div>
		<div id="sec_news">
			<h3><span class="orange">Security</span> News</h3>
			<dl>
				<dt>Vivamus id ligula....</dt>
				<dd>Proin quis ante Proin quis anteProin quis anteProin quis anteProin quis anteProin quis ante......</dd>
			</dl>
			<dl>
				<dt>Vivamus id ligula....</dt>
				<dd>Proin quis ante Proin quis anteProin quis anteProin quis anteProin quis anteProin quis ante......</dd>
			</dl>
		</div>
		<div id="news_notice">
			<h3 class="brown">News &amp; Notice</h3>
			<table>
			<%
			int pageSize = 5;
			int startRow = 1;
			BoardDAO bdao = new BoardDAO();
			List<BoardBean> boardList = bdao.getBoardList(startRow, pageSize);
			
			for(int i=0; i<boardList.size(); i++){
				BoardBean bb = boardList.get(i);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				%>
				<tr onclick="location.href='../center/content.jsp?num=<%=bb.getNum() %>'"><td class="contxt"><a href="#"><%=bb.getSubject() %></a></td><td><%=sdf.format(bb.getDate()) %></td></tr>
				<%
			}
			%>
			</table>
		</div>
	</article>
	
<div class="clear"></div>
<!-- 푸터 -->
<jsp:include page="../inc/bottom.jsp"/>
</div>
</body>
</html>