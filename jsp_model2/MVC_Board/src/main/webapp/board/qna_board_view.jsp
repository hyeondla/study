<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String nowpage = (String)request.getAttribute("page");
BoardBean article = (BoardBean)request.getAttribute("article");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
	#articleForm {
		width: 500px;
		height: 500px;
		border: 1px solid red;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
	
	#basicInfoArea {
		height: 40px;
		text-align: center;
	}
	
	#articleContentArea {
		background: orange;
		margin-top: 20px;
		height: 350px;
		text-align: center;
		overflow: auto;
		white-space: pre-line;
	}
	
	#commandList {
		margin: auto;
		width: 500px;
		text-align: center;
	}
</style>
</head>
<body>
	<!-- 게시판 상세내용 보기 -->
	<section id="articleForm">
		<h2>글 상세내용 보기</h2>
		<section id="basicInfoArea">
		제목 : <%=article.getBoard_subject() %><br>
		첨부파일 : <a href="./boardUpload/<%=article.getBoard_file_real() %>"  download="<%=article.getBoard_file_original() %>"><%=article.getBoard_file_original() %></a><br>
		</section>
		<section id="articleContentArea">
		<%=article.getBoard_content() %>
		</section>
	</section>
	<section id="commandList">
		<input type="button" value="답변" onclick="location.href='BoardReplyForm.bo?board_num=<%=article.getBoard_num()%>&page=<%=nowpage%>'">
		<input type="button" value="수정" onclick="location.href='BoardModifyForm.bo?board_num=<%=article.getBoard_num()%>&page=<%=nowpage%>'">
		<input type="button" value="삭제" onclick="location.href='BoardDeleteForm.bo?board_num=<%=article.getBoard_num()%>&page=<%=nowpage%>'">
		<input type="button" value="목록" onclick="location.href='BoardList.bo?page=<%=nowpage%>'">
	</section>
</body>
</html>




