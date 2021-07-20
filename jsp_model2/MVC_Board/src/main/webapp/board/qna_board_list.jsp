<%@page import="vo.PageInfo"%>
<%@page import="vo.BoardBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 전달받은 request 객체로부터 데이터 가져오기(getAttribute())
	// "pageInfo", "articleList" 속성명을 지정하여 객체 꺼내서 저장(타입 체크 생략)
	ArrayList<BoardBean> articleList = (ArrayList<BoardBean>)request.getAttribute("articleList");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	
	// pageInfo 객체로부터 페이지 관련 값들을 꺼내서 변수에 저장
	// => 주의! page 값은 내장 객체명과 동일하므로 다른 변수명 사용해야함
	int currentPage = pageInfo.getPage();
	int listCount = pageInfo.getListCount();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
	#listForm {
		width: 1024px;
		max-height: 610px;
		border: 1p solid red;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		margin: auto;
		width: 1024px;
	}
	
	#tr_top {
		background: orange;
		text-align: center;
	}
	
	#pageList {
		margin: auto;
		width: 1024px;
		text-align: center;
	}
	
	#emptyArea {
		margin: auto;
		width: 1024px;
		text-align: center;
	}
	
	#buttonArea {
		margin: auto;
		width: 1024px;
		text-align: right;
	}
	
	
</style>
</head>
<body>
	<!-- 게시판 리스트 -->
	<section id="listForm">
		<h2>게시판 글 목록</h2>
		<table>
			<%
			if(articleList != null && listCount > 0) {
			%>
				<tr id="tr_top">
					<td width="100px">번호</td>
					<td>제목</td>
					<td width="150px">작성자</td>
					<td width="150px">날짜</td>
					<td width="100px">조회수</td>
				</tr>
				<%
				for(BoardBean article : articleList) {
				%>
				<tr>
					<td align="center"><%=article.getBoard_num() %></td>
					<td>
					<%if(article.getBoard_re_lev() != 0) { %>
							<%for(int j = 0; j <= article.getBoard_re_lev(); j++) { %>
									&nbsp;
							<%} %>
							▶
					<%} %>
						<a href="BoardDetail.bo?board_num=<%=article.getBoard_num() %>&page=<%=currentPage %>">
						<%=article.getBoard_subject() %>
						</a>
					</td>
					<td align="center"><%=article.getBoard_name() %></td>
					<td align="center"><%=article.getBoard_date() %></td>
					<td align="center"><%=article.getBoard_readcount() %></td>
				</tr>
				
				<%}%>
		</table>
	</section>
	<section id="buttonArea">
		<input type="button" value="글쓰기" onclick="location.href='BoardWriteForm.bo'" />
	</section>
	<section id="pageList">
	<%if(currentPage <= 1) {%>
			<input type="button" value="이전">&nbsp;
	<%} else {%>
			<input type="button" value="이전" onclick="location.href='BoardList.bo?page=<%=currentPage - 1 %>'">&nbsp;
	<%} %>
	
	<%for(int i = startPage; i <= endPage; i++) { 
			if(i == currentPage) { %>
				[<%=i %>]
		<%} else { %>
				<a href="BoardList.bo?page=<%=i %>">[<%=i %>]</a>&nbsp;
		<%} %>
	<%} %>
	
	<%if(currentPage >= maxPage) { %>
			<input type="button" value="다음">
	<%} else { %>
			<input type="button" value="다음" onclick="location.href='BoardList.bo?page=<%=currentPage + 1 %>'">
	<%} %>
	</section>
	<%
	} else {
	%>
	<section id="emptyArea">등록된 글이 없습니다</section>
	<%
	}
	%>
</body>
</html>

















