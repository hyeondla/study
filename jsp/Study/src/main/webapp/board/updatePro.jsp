<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
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
request.setCharacterEncoding("utf-8");

int num = Integer.parseInt(request.getParameter("num"));
String name = request.getParameter("name");
String pass = request.getParameter("pass");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

BoardDAO bdao = new BoardDAO();

BoardBean bb = bdao.numCheck(num, pass);

if(bb != null){
	
	BoardBean bb2 = new BoardBean();
	
	bb2.setNum(num);
	bb2.setName(name);
	bb2.setPass(pass);
	bb2.setSubject(subject);
	bb2.setContent(content);
	
	bdao.updateBoard(bb2);
	
	%>
	<script type="text/javascript">
		alert("수정되었습니다");
		location.href="list.jsp";
	</script>
	<%
} else {
	%>
	<script type="text/javascript">
		alert("입력하신 정보가 틀립니다");
		history.back();
	</script>
	<%
}
%>
</body>
</html>