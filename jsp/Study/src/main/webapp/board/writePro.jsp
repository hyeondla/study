<%@page import="board.BoardDAO"%>
<%@page import="board.BoardBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>board/writePro.jsp</h1>
<%
// request 한글처리
request.setCharacterEncoding("utf-8");
// request 태그파라미터 가져오기 name, pass, subject, content
String name=request.getParameter("name");
String pass=request.getParameter("pass");
String subject=request.getParameter("subject");
String content=request.getParameter("content");
int readcount=0;
Timestamp date=new Timestamp(System.currentTimeMillis());

// 패키지 board 파일  BoardDAO 만들기
// 리턴값 없음 insertBoard(BoardBean bb) 메서드 만들기

// 패키지 board 파일 BoardBean 만들기
// private 멤버변수 정의
// num , name, pass, subject, content, readcount, date
// set get 메서드 만들기

// BoardBean bb 객체생성
BoardBean bb=new BoardBean();
// set 메서드 호출 => 파라미터값을 멤버변수 저장
bb.setName(name);
bb.setPass(pass);
bb.setSubject(subject);
bb.setContent(content);
bb.setReadcount(readcount);
bb.setDate(date);

// BoardDAO bdao 객체생성
BoardDAO bdao=new BoardDAO();
// insertBoard(bb) 메서드 호출
bdao.insertBoard(bb);

// 글목록 list.jsp 이동
response.sendRedirect("list.jsp");
%>

</body>
</html>







