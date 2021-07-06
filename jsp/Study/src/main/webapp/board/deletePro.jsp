<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>board/deletePro.jsp</h1>
<%
// request 저장된 num,pass 태그파라미터 가져오기
int num=Integer.parseInt(request.getParameter("num"));
String pass=request.getParameter("pass");

//BoardDAO bdao 객체생성
BoardDAO bdao=new BoardDAO();

// BoardBean bb = numCheck(num,pass) 메서드 호출
BoardBean bb=bdao.numCheck(num, pass);
// bb이 null이 아니면  deleteBoard(num) list.jsp 이동
// bb가 null이면 "입력하신 정보 틀립니다"  뒤로이동 
if(bb!=null){
	bdao.deleteBoard(num);
	// list.jsp 이동
	response.sendRedirect("list.jsp");
}else{
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







