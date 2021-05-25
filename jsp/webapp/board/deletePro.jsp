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
int num = Integer.parseInt(request.getParameter("num"));
String pass = request.getParameter("pass");

BoardDAO bdao = new BoardDAO();
BoardBean bb = bdao.numCheck(num, pass);

if(bb != null){
	
	bdao.deleteBoard(num);
	
	%>
	<script type="text/javascript">
		alert("삭제되었습니다")
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