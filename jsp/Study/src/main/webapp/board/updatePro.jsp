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
<h1>board/updatePro.jsp</h1>
<%
// request한글처리
request.setCharacterEncoding("utf-8");
// request 태그파라미터 가져오기 num,name,pass,subject,content
int num=Integer.parseInt(request.getParameter("num"));
String name=request.getParameter("name");
String pass=request.getParameter("pass");
String subject=request.getParameter("subject");
String content=request.getParameter("content");

// BoardDAO bado 객체생성
BoardDAO bdao=new BoardDAO();
// 리턴할형 BoardBean  numCheck(int num,String pass) 메서드 정의
// BoardBean bb = numCheck(num,pass) 메서드 호출
BoardBean bb=bdao.numCheck(num, pass);
// bb이 null이 아니면  BoardBean bb2 객체생성 수정할정보를 저장
//                  updateBoard(bb2) list.jsp 이동
// bb가 null이면 "입력하신 정보 틀립니다"  뒤로이동 
if(bb!=null){
	// num pass 일치
	BoardBean bb2=new BoardBean();
	bb2.setNum(num);
	bb2.setName(name);
	bb2.setPass(pass);
	bb2.setSubject(subject);
	bb2.setContent(content);
	
	bdao.updatgeBoard(bb2);
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











