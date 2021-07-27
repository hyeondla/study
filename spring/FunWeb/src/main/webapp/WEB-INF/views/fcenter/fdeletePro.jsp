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
bdao.fdeleteBoard(num);
%>
<script type="text/javascript">
	alert("삭제되었습니다");
	location.href="fnotice.jsp";
</script>
</body>
</html>