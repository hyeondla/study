<%@page import="fboard.FileBoardBean"%>
<%@page import="fboard.FileBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int num = Integer.parseInt(request.getParameter("num"));

FileBoardDAO bdao = new FileBoardDAO();
FileBoardBean bb = bdao.fgetBoard(num);

if(bb != null){
	%>
	<form action="fupdatePro.jsp" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="<%=num %>">
	<table border="1">
	<tr><td>글쓴이</td><td><input type="text" name="name" value="<%=bb.getName() %>" readonly></td></tr>
	<tr><td>비밀번호</td><td><input type="password" name="pass"></td></tr>
	<tr><td>제목</td><td><input type="text" name="subject" value="<%=bb.getSubject() %>"></td></tr>
	<tr><td>파일</td><td><input type="file" name="file"><%=bb.getFile() %>
						 <input type="hidden" name="oldfile" value="<%=bb.getFile() %>"></td></tr>
	<tr><td>내용</td><td><textarea rows="10" cols="20" name="content"><%=bb.getContent() %></textarea></td></tr>
	<tr><td colspan="2"><input type="submit" value="글수정"></td></tr>
	</table>
	</form>
	<%
}
%>

</body>
</html>